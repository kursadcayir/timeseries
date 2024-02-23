<template>
  <Line ref="line" v-if="loaded" :data="chartData" :options="options" />
</template>

<script setup lang="ts">
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
import { ref } from 'vue';
import { Line } from 'vue-chartjs'
import axios from 'axios';


ChartJS.register(
  CategoryScale,
  LinearScale,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
)
const chartData = ref({})
const options = ref({})


const loaded = ref(false);

function setOptions(meta: any = null) {
  options.value = {
    responsive: true, // Disable responsiveness
    maintainAspectRatio: false, // Allow custom aspect ratio
    scales: {
      y: {
        ticks: {
          // forces step size to be 50 units
          stepSize:  0.0001
        }
      }
    },
    plugins: {
      title: {
        display: true,
        text: "symbol: " + meta.symbol + " interval:" + meta.interval,
      },
    }
  }
}

async function fetchData() {
  // Implement your actual API call and data processing here
  // Update `chartData` with the fetched data
  // Set `loaded` to true after successful data fetch
  let res = null;
  try {

    res = await axios.get('http://localhost:8081/timeseries?start_date=2024-02-01%2023:52:00&end_date=2024-02-13%2023:52:00')
    console.log(res.data);
    // res = null  
    console.log('Data fetched');
  } catch (error) {
    console.error('Error fetching data:', error);
  }

  if (res == null || res.data == null || res.data.status != 'ok') {
    return;
  }
  const status = res.data.status;
  const values = res.data.values.reverse();
  const meta = res.data.meta;

  const labels = values.map((value: { datetime: any; }) => value.datetime);

  const dataClose = values.map((value: { close: any; }) => value.close);

  const dataOpen = values.map((value: { open: any; }) => value.open);

  const dataLow = values.map((value: { low: any; }) => value.low);

  const dataHigh = values.map((value: { high: any; }) => value.high);

  setOptions(meta)

  console.log(status, values, meta, labels, dataClose, dataOpen, dataLow, dataHigh)


  chartData.value = {
    labels: labels,
    datasets: [
      {
        label: 'Data Open',
        backgroundColor: '#20fc03',
        data: dataOpen
      },
      {
        label: 'Data Close',
        backgroundColor: '#fff700',
        data: dataClose
      },
      {
        label: 'Data Low',
        backgroundColor: '#00ffff',
        data: dataLow
      },
      {
        label: 'Data High',
        backgroundColor: '#a200ff',
        data: dataHigh
      }

    ]
  }

  loaded.value = true;



}

fetchData();

</script>
