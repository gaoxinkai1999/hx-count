<template>
  <div class="hello">

    <van-field
        readonly
        clickable
        name="picker"
        :value="value"
        label="店铺名"
        placeholder="点击选择店铺"
        @click="showPicker = true"
    />
    <van-popup v-model="showPicker" position="bottom">
      <van-picker
          show-toolbar
          :columns="columns"
          @confirm="onConfirm"
          @cancel="showPicker = false"
          value-key="name"
      />
    </van-popup>
    <div v-if="result!=''">

        <el-table
            :data="result"
            style="width: 100%">
          <el-table-column
              prop="name"
              label="姓名">
          </el-table-column>
          <el-table-column
              prop="1块"
              label="1块">
          </el-table-column>
          <el-table-column
              prop="3块"
              label="3块">
          </el-table-column>
          <el-table-column
              prop="5块"
              label="5块">
          </el-table-column>
          <el-table-column
              prop="10块"
              label="10块">
          </el-table-column>
          <el-table-column
              label="合计">
            <template slot-scope="scope">
              {{ scope.row['1块'] + scope.row['3块']*3 + scope.row['5块']*5 + scope.row['10块']*10 }}
            </template>
          </el-table-column>
        </el-table>

    </div>
  </div>
</template>

<script>
import {Toast} from "vant";

export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  data() {
    return {
      value: '',
      columns: [
      ],
      showPicker: false,
      dept_id: '',
      result:''
    }
  },
  created() {
    this.$http.post('getDepts').then(res=>{
      this.columns=res.data

    })
  },
  methods: {
    onConfirm(value) {
      this.value = value.name;
      this.dept_id=value.id;
      this.showPicker = false;
      this.getResult()
    },
    getResult(){
      this.$http.post('getResult',{'dept_id':this.dept_id}).then(res=>{
        this.result=res.data
      })
    },
    onChange(picker, value, index) {
      Toast(`当前值：${value}, 当前索引：${index}`);
    },
    onCancel() {
      Toast('取消');
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
