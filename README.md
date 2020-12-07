# sparrow-platform

关于平台的详细介绍，请参考平台的wiki https://github.com/fanmeijian/sparrow-platform/wiki

后端使用：
1) 创建数据库 请参考wiki
2) 初始化数据 请参考wiki
3) mvn spring-boot:run

关于认证登录部分，请参考认证服务器
https://github.com/fanmeijian/sparrow-authorizaion-server

数据权限，第一个为id参数，第二个为model的全名，第三个为权限
@PreAuthorize("hasPermission(#id,'com.ywsoft.standalone.framework.entity.SwdRole','READ')")

字段权限：尚未完善，path留空，permission为权限，用在返回单个model的地方上
@DataPermissionInterface(path = "", permission = "READ")

前端请参考项目sparrow-platform-ng https://github.com/fanmeijian/sparrow-platform-ng

接口文档请参考
http://localhost:8091/sparrow-platform/swagger-ui/index.html?configUrl=/sparrow-platform/v3/api-docs/swagger-config#