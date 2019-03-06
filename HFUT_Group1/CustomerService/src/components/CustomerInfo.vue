<template>
  <div>
    <span class="title-font">客服综评</span>
    <div>
      <el-table :data="customerService" height='500px' v-loading="loading">
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="drop-data">
              <el-form-item label="客服编号:">
                <span>{{ props.row.cid }}</span>
              </el-form-item>
              <el-form-item label="性别:">
                <span v-if="props.row.gender === 0">女</span>
                <span v-else>男</span>
              </el-form-item>
              <el-form-item label="年龄:">
                <span>{{ props.row.age }}</span>
              </el-form-item>
              <el-form-item label="邮箱地址:">
                <span>{{ props.row.mailaddress }}</span>
              </el-form-item>
              <el-form-item label="电话号码:">
                <span>{{ props.row.telno}}</span>
              </el-form-item>
              <el-form-item label="综合评分:">
                <span>{{ props.row.judge }}</span>
              </el-form-item>
              <el-form-item label="已服务人数:">
                <span>{{ props.row.serivcNnum }}</span>
              </el-form-item>
              <el-form-item label="注册时间:">
                <span>{{ props.row.regTime }}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column prop="images" label="头像" width="180">
          <template slot-scope="scope">
            <img v-lazy="scope.row.images === ' '?'../static/voids.jpg':'scope.row.images'" class="picture" />
          </template>
        </el-table-column>
        <el-table-column prop="cid" label="客服编号" width="200">
        </el-table-column>
        <el-table-column prop="judge" label="综合评分" width="300" sortable>
          <template slot-scope="scope">
            <el-rate v-model="scope.row.judge" disabled show-score text-color="#ff9900" score-template="{value}">
            </el-rate>
          </template>
        </el-table-column>
        <el-table-column prop="status" label="状态" :filters="[{ text: '在线', value: 1 }, { text: '离线', value: 0 }]" :filter-method="filterStatus" filter-placement="bottom-end">
          <template slot-scope="scope">
            <el-tag :type="scope.row.status === 0 ? 'info' : 'success'" close-transition v-if="scope.row.status === 0">离线</el-tag>
            <el-tag :type="scope.row.status === 0 ? 'info' : 'success'" close-transition v-else>在线</el-tag>
          </template>
        </el-table-column>
      </el-table>
    </div>
  </div>
</template>
<script type="text/javascript">
export default {
  data() {
    return {
      customerService: [],
      intelval: null,
      loading: true
    }
  },
  methods: {
    filterStatus(value, row) {
      return row.status === value;
    },
    showCustomerService() {
      this.$axios.get('/api/showservice.action')
        .then((res) => {
          this.loading = false
            this.customerService = res.data
          },
          (err) => {
            console.log("error")
          })
    }
  },
  mounted() {
    this.showCustomerService()
    clearInterval(this.intelval);
    this.intelval = setInterval(() => {
      this.showCustomerService()
    }, 30000)

  }
}

</script>
<style type="text/css" scoped>
.title-font {
  font-size: 20px;
  font-family: "Hiragino Sans GB";
  font-weight: bold;
}

el-table {
  width: 70%;
}

.drop-data {
  font-size: 0;
}

.drop-data label {
  width: 90px;
  color: #99a9bf;
}

.drop-data .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
.picture {
  width: 60px;
  height: 60px;
  border-radius: 42px;
}

</style>
