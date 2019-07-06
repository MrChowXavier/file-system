<template>
  <div id="div">
    <div id="register">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名称" prop="username"><el-input v-model="ruleForm.username"></el-input></el-form-item>

        <el-form-item label="用户密码" prop="userpswd"><el-input v-model="ruleForm.userpswd" show-password></el-input></el-form-item>

        <el-form-item label="所在城市" prop="userlocation">
          <el-select v-model="ruleForm.userlocation" placeholder="请选择城市" style="width: 100%;">
            <el-option label="北京" value="BJ"></el-option>
            <el-option label="上海" value="SH"></el-option>
            <el-option label="广州" value="GZ"></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="出生日期" required>
          <el-col :span="11">
            <el-form-item prop="userbirthday">
              <el-date-picker type="date" placeholder="选择日期" v-model="ruleForm.userbirthday" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
        </el-form-item>

        <el-form-item label="性别" prop="usergender">
          <el-radio-group v-model="ruleForm.usergender">
            <el-radio label="男"></el-radio>
            <el-radio label="女"></el-radio>
          </el-radio-group>
        </el-form-item>

        <el-form-item label="编程语言" prop="userlanguage">
          <el-checkbox-group v-model="ruleForm.userlanguage">
            <el-checkbox label="Java" name="type"></el-checkbox>
            <el-checkbox label="Python" name="type"></el-checkbox>
            <el-checkbox label="SQL" name="type"></el-checkbox>
            <el-checkbox label="Shell" name="type"></el-checkbox>
          </el-checkbox-group>
        </el-form-item>

        <el-form-item label="自我介绍" prop="userdesc">
          <el-input type="textarea" v-model="ruleForm.userdesc"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即注册</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      ruleForm: {
        username: '',
        userpswd: '',
        userlocation: '',
        userbirthday: '',
        usergender: '',
        userlanguage: [],
        userdesc: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名称', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ],
        userpswd: [
          { required: true, message: '请输入用户密码', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ],
        userlocation: [
          { required: true, message: '请选择城市', trigger: 'change' }
        ],
        userbirthday: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        usergender: [
          { required: true, message: '请选择性别', trigger: 'change' }
        ],
        userlanguage: [
          { type: 'array', required: true, message: '请至少选择一门语言', trigger: 'change' }
        ],
        userdesc: [
          { required: true, message: '请填写自我介绍', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    submitForm (formName) {
      console.log(this.ruleForm.username)
      console.log(this.ruleForm.userpswd)
      console.log(this.ruleForm.userlocation)
      console.log(this.ruleForm.userbirthday)
      console.log(this.ruleForm.usergender)
      console.log(this.ruleForm.userlanguage)
      console.log(this.ruleForm.userdesc)

      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.axios.post('/filesys/user/register', {
            username: this.ruleForm.username,
            userpswd: this.ruleForm.userpswd,
            userlocation: this.ruleForm.userlocation,
            userbirthday: this.ruleForm.userbirthday,
            usergender: this.ruleForm.usergender,
            userdesc: this.ruleForm.userdesc
          })
            .then(res => {
              if (res.data.status === 'success') {
                this.$message({ message: res.data.data, type: 'success' })

                this.$router.push('/mainpage')
              } else {
                this.$message({ message: res.data.data.errCode + ':' + res.data.data.errMsg, type: 'error' })
              }
            })
            .catch(res => {
              console.log(res.data)
            })
        } else {
          // alert('验证不通过！')
          this.$message({ message: '验证不通过！', type: 'warning' })
        }
      })
    },
    resetForm (formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>

<style scoped>
  #div{
    position: relative;
  }
  #register{
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
