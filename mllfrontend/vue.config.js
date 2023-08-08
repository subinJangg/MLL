const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: "../src/main/resources/static",  // 빌드 타겟 디렉토리
  devServer: {
    port: 8089,
    proxy: {
      '/api': {
        // '/api' 로 들어오면 포트 8099(스프링 서버)로 proxy 처리
        target: 'http://localhost:8098',
        changeOrigin: true // cross origin 허용 (서로 다른 포트 리소스 공유)
      }
    }
  },
})