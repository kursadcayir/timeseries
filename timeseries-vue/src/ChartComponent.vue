<template>
  <div>
    <Line :data="chartData" :options="chartOptions" />
  </div>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import { Line} from 'vue-chartjs';

export default defineComponent({
  props: {
    chartData: {
      type: Object as () => any,
      required: true,
    },
    chartOptions: {
      type: Object as () => any,
      required: true,
    },
  },
  components: {
    Line, // Import LineChart component from vue-chartjs
  },
});
</script>
