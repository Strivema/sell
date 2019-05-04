# 虚拟机说明文档
VirtualBox-5.1.22
虚拟机系统 centos7.3
账号 root
密码 123456
#### 包括软件
* jdk 1.8.0_111
* nginx 1.11.7
* mysql 5.7.17
* redis 3.2.8

##### jdk
* 路径 /usr/local/jdk1.8.0_111

##### nginx
* 路径 /usr/local/nginx
* 启动 nginx
* 重启 nginx -s reload

##### mysql
* 配置 /etc/my.conf
* 账号 root
* 密码 123456
* 端口 3306
* 启动 systemctl start mysqld
* 停止 systemctl stop mysqld

##### redis
* 路径 /usr/local/redis
* 配置 /etc/reis.conf
* 端口 6379
* 密码 123456
* 启动 systemctl start redis
* 停止 systemctl stop redis

##### tomcat
* 路径 /usr/local/tomcat
* 启动 systemctl start tomcat
* 停止 systemctl stop tomcat


https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx34177639cfd29045&redirect_uri=http://sell-from-jll.natapp1.cc/sell/weixin/auth&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect

https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx34177639cfd29045&secret=952005dda5a3bbffdabcf62a3c0472b3&code=CODE&grant_type=authorization_code

{"access_token":"17_TMQBiJfx-g7nB9aEVNRrqoVu33I4VLOncBRjdektni4aZxzX4TuCeB_HNu0Sls7fUkFwkU1cGL9XoPetCZ3PLVzexZKOKuStG_LM_FqgzZ0","expires_in":7200,"refresh_token":"17_mbd3nA-cs8QoNurB9Fua2kOpIjV_wU2wbVBTYcBPoqgMU9FpslEaw6yCC0vF_FsPxZF0pHNclsMd4NQOt6xed6dqJSjKMjGbcPJK48inWK0","openid":"oNtRj0ZFTw4vOqCd_SoWP9LQzqM8","scope":"snsapi_base"}

oNtRj0ZFTw4vOqCd_SoWP9LQzqM8






