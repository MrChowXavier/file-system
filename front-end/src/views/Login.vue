<template>
  <div id="div">
    <div id="login">
    <img alt="Vue logo" src="../assets/logo.png">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="用户名称" prop="username"><el-input v-model="ruleForm.username"></el-input></el-form-item>
      <el-form-item label="用户密码" prop="userpswd"><el-input v-model="ruleForm.userpswd" show-password></el-input></el-form-item>
      <el-form-item>
        <el-button type="primary" @click="login('ruleForm')" round>登陆</el-button>
      </el-form-item>
    </el-form>
    </div>
  </div>
</template>

<script>
export default {
  username: 'login',
  data () {
    return {
      ruleForm: {
        username: '',
        userpswd: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名称', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ],
        userpswd: [
          { required: true, message: '请输入用户密码', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    login (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios({
            // url: '/filesys/user/login',
            url: 'http://127.0.0.1:9090/filesys/user/login',
            method: 'post',
            params: { userName: this.ruleForm.username, userPswd: this.ruleForm.userpswd }
          })
            .then(res => {
              if (res.data.status === 'success') {
                // this.$message({ message: res.data.data, type: 'success' })
                this.$message({ message: '恭喜您！登陆成功！', type: 'success' })
                console.log(res.data)
                this.$store.commit('setToken', res.data.data)
                this.$store.commit('setUserName', localStorage.userName)
                // localStorage.token = res.data.data
                // localStorage.userName = this.ruleForm.username
                console.log('------' + localStorage.userName)
                this.$router.push('/mainpage')
              } else {
                this.$message({ message: res.data.data.errCode + ':' + res.data.data.errMsg, type: 'error' })
              }
            },
            res => {
              console.log(res.data)
            })
        } else {
          this.$message({ message: '验证不通过！', type: 'warning' })
        }
      })
    }
  }
}
</script>

<style scoped>
  #div{
    position: relative;
  }
  #login{
    text-align: center;
    width: 60%;
    position: absolute;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0;
    margin: auto;
  }
</style>
