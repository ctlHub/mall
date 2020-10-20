<template>
  <div class="login_container">
    <div class="login-box">
      <!-- 头像区域 -->
      <div class="avatar_box">
        <img src="../../assets/images/logo.png" />
      </div>
      <!-- 表单区域 -->
      <el-form ref="ruleForm" :model="loginForm" :rules="loginFormRules" label-width="0" class="login_form">
        <!-- 用户名 -->
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" prefix-icon="el-icon-user-solid"></el-input>
        </el-form-item>
        <!-- 密码 -->
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
        </el-form-item>
        <!-- 按钮 -->
        <el-form-item class="btns">
          <el-button type="primary" @click="login()">登陆</el-button>
          <el-button type="info" @click="resetForm()">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      // 表单数据绑定
      loginForm: {
        username: '122',
        password: '1231232'
      },
      // 表单数据验证
      loginFormRules: {
        // 验证用户名称
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 8, message: '长度在 3 到 8 个字符', trigger: 'blur' }
        ],
        // 验证密码
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    resetForm () {
      this.$refs.ruleForm.resetFields()
    },
    login () {
      // 实现登录流程
      this.$refs.ruleForm.validate(async valid => {
        if (!valid) return false
        // const result = await this.$http.post('login', this.loginForm)
        // console.log(result)
        this.$router.push('/pc/index')
      })
    }
  }
}
</script>

<style lang="less" scoped="scoped">
  .login_container {
    background-color: #2b4b6b;
    height: 100%;
  }

  .login-box {
    width: 28.125rem;
    height: 18.75rem;
    background-color: white;
    border-radius: 0.1875rem;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
  }

  .avatar_box {
    height: 8.125rem;
    width: 8.125rem;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 0.625rem;
    box-shadow: 0 0 0.625rem #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: white;
    img {
      height: 100%;
      width: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }

  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 1.25rem;
    box-sizing: border-box;
  }

  .btns {
    display: flex;
    justify-content: flex-end;
  }
</style>
