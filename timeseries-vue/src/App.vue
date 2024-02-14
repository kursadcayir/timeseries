<template>
  <div>
    <h2>Stock Chart</h2>
    <button @click="fetchData">Fetch Data</button>
    <ChartComponent v-if="data" :chartdata="{...chartData}" :options="{...chartOptions}" />
    <div v-else>Loading...</div>
  </div>
</template>

<script lang="ts">
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
} from 'chart.js'

import { defineComponent, ref } from 'vue';
import axios from 'axios';
import ChartComponent from './ChartComponent.vue';

ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
)

export default defineComponent({
  components: {
    ChartComponent, // Define the Chart component

  },
  setup() {
    const data = ref(null);
    const chartData = ref({
      labels: [],
      datasets: [
        {
          label: 'Stock Price',
          backgroundColor: 'rgba(75, 192, 192, 0.2)',
          borderColor: 'rgba(75, 192, 192, 1)',
          data: [],
        },
      ],
    });
    const chartOptions = ref({
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: true,
          },
        }],
      },
      responsive: true,
    maintainAspectRatio: false
    });

    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8081/timeseries?start_date=2024-02-01%2023:52:00&end_date=2024-02-13%2023:52:00');
        data.value = response.data;
        buildChartData();
      } catch (error) {
        console.error('Error fetching data:', error);
        // Handle errors gracefully, e.g., display an error message to the user
      }
    };

    const buildChartData = () => {
      if (data.value) {
        const { values } = data.value;
        chartData.value.labels = values.map((item: any) => item.datetime);
        chartData.value.datasets[0].data = values.map((item: any) => item.close);
      }
    };

    return {
      data,
      chartData,
      chartOptions,
      fetchData,
    };
  },
});
</script>
