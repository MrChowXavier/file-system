<template>
  <div id="div">
    <div id="mainPage">
      <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
          <el-menu :default-openeds="['1', '3']">
            <el-submenu index="1">
              <template slot="title"><i class="el-icon-message"></i>文件模块</template>
              <el-menu-item-group title="文件预览">
                <el-menu-item index="1-1">文件清单</el-menu-item>
              </el-menu-item-group>
              <el-menu-item-group title="文件上传">
                <el-menu-item index="1-3">上传</el-menu-item>
              </el-menu-item-group>
              <el-submenu index="1-4">
                <template slot="title">选项4</template>
                <el-menu-item index="1-4-1">选项4-1</el-menu-item>
              </el-submenu>
            </el-submenu>

            <el-submenu index="2">
              <template slot="title"><i class="el-icon-menu"></i>其他</template>
              <el-menu-item-group title="分组1">
                <el-menu-item index="2-1">选项1</el-menu-item>
              </el-menu-item-group>

              <el-menu-item-group title="分组2">
                <el-menu-item index="2-3">选项2</el-menu-item>
              </el-menu-item-group>
            </el-submenu>

          </el-menu>
        </el-aside>

        <el-container>
          <el-header style="text-align: right; font-size: 12px">
            <el-dropdown @command="handleCommand">
              <span class="el-dropdown-link">
                更多<i class="el-icon-arrow-down el-icon--right" style="margin-right: 15px"></i>
              </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="show">查看</el-dropdown-item>
                <el-dropdown-item command="add">新增</el-dropdown-item>
                <el-dropdown-item command="del">删除</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <span>当前登陆用户是：{{username}}</span>
          </el-header>

          <el-main>
            <el-table :data="getFileList">
              <el-table-column prop="fileName" label="文件名" width="200"></el-table-column>
              <el-table-column prop="filePath" label="存储路径" width="300"></el-table-column>
              <el-table-column prop="fileSize" label="文件大小" width="100"></el-table-column>
            </el-table>
          </el-main>
        </el-container>
      </el-container>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Main',
  data () {
    const item = {
      filename: '',
      filepath: ''
    }
    return {
      tableData: Array(20).fill(item),
      username: this.$store.state.username
      // fileList: [ {   filename: 'w', filepath: '/home' }, { filename: 'p', filepath: '/home' } ]
    }
  },
  computed: {
    getFileList () {
      return this.$store.state.filelist
      // return [{ 'fileName': 'p.ppt', 'filePath': '/home', 'fileSize': '10' }, { 'fileName': 'w.word', 'filePath': '/home', 'fileSize': '10' }]
    }
  },
  methods: {
    handleCommand (command) {
      if (command === 'show') {
        this.axios({
          url: 'http://127.0.0.1:9090/filesys/file/get',
          method: 'get',
          params: { token: this.$store.state.token }
        })
          .then(res => {
            if (res.data.status === 'success') {
              this.$store.commit('setFileList', res.data.data)
            } else {
              this.$message({ message: res.data.data.errCode + ':' + res.data.data.errMsg, type: 'error' })
            }
          },
          res => {
            console.log(res.data)
          })
      }
      // if (command === 'add') {
      //   this.fileList.push(
      //     { fileName: 'x', filePath: '/home' }
      //   )
      // }
    }
  }
}
</script>

<style scoped>
  #div{
    position: relative;
  }
  #mainPage{
    text-align: center;
    width: 90%;
    position: absolute;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    margin: auto;
  }
  .el-header {
    background-color: #FFF;
    color: #000;
    line-height: 60px;
  }
  .el-aside {
    color: #FFF;
  }
  .el-table {
    width: 100%;
  }
</style>
