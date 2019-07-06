module.exports = {
  devServer: {
    proxy: {
      '/filesys': {
        target: 'http://192.168.2.136:9090/filesys',
        // ws: true,
        changeOrigin: true
      },
      '/foo': {
        target: '<other_url>'
      }
    }
  }
}
