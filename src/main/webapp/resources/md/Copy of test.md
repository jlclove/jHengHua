# SE Restful Api 最佳实践 Ver1.1
@(部分节选自伟大的应特耐特)

[TOC]

##版本变更记录
`Ver1.0`
- *新增* Api 设计原则
- *新增* Api实战
- *新增* 增值服务
- *新增* 写在最后
`Ver1.1`
- *新增* 建议推广的分页实现
- *更新* 返回带分页的实体列表 建议增加分页相关参数

##Api设计原则

1. 当标准合理的时候遵守标准。
2. 应该对程序员友好，并且在浏览器地址栏容易输入。
3. 应该简单，直观，容易使用的同时优雅。
4. 应该具有足够的灵活性来支持上层ui。
5. 设计权衡上述几个原则。

##Api实战

### 定义好资源，活用Method

*举例*

- `GET` `/api/users`         `获取用户列表`
- `GET` `/api/users/86455`   `获得86455为工号的用户`
- `POST` `/api/users`       `新增用户`
- `PUT`  `/api/users/86455` `更新用户的完整信息，PATCH不支持的话可以用`
- `DELETE` `/api/users/86455` `删除用户信息`
- `PATCH` `/api/users/86455` `更新用户的部分信息，如果不存在则新建，类似 saveOrUpdate`

>PATCH 的支持有要求
>>- httpClient 4.2 or later
>>- spring 3.2 or later
>>- tomcat8 or later
>>- jdk8 or later

**大家能直接看到利用http的强大实现了对资源的CURD操作~~ 真是屌爆了;Url是资源的直接展示，对于其余的一些动态参数如页码、也页尺寸等建议在URL后用?的方式实现**

### 多重资源的场景

*举例*

- `GET` `/api/property/172618/follows`         `获取172618房源下的跟进列表`
- `GET` `/api/property/172618/follows/1261`   `获取`
- `POST` `/api/property/172618/follows`       `新增172618房源下的跟进`
- `PUT`  `/api/property/172618/follows/1261` `更新172618房源下ID为1261的跟进的完整信息，PATCH不支持的话可以用`
- `DELETE` `/api/property/172618/follows/1261` `删除172618房源下ID为1261的跟进信息`
- `PATCH` `/api/property/172618/follows/1261` `更新172618房源下ID为1261跟进的部分信息，如果不存在则新建，类似 saveOrUpdate`


### 根据Api标题定义的返回结果，直接用就行

*大家在调用某接口的时候，都是预期的；那么我们api在返回的时候可以转成想要的entity会不会更舒服呢？当然：建议对异常做统一处理*  [异常处理](#errorHandler)

#####*返回实体对象（获得指定的员工信息）*
```json
{
    "userCode":86455,
    "userName":"胡杰",
    "age":35,
    "birthday":1425520800000
}
```

#####*返回实体列表（获得员工列表）*
```json
[
    {
        "userCode":86455,
        "userName":"胡杰",
        "age":35,
        "birthday":1425520800000
    },
    {
        "userCode":80099,
        "userName":"张三丰",
        "age":110,
        "birthday":1425525800000
    }
]
```

#####*返回带分页的实体列表（获得员工列表以及总员工数等）*
```json
{   
    "pageSize":20,      // 页尺寸
    "pageNo":8,         // 页码
    "pageCount":17,     // 总页数
    "recordCount":182,  // 总记录数
    "list":[
                {
                    "userCode":86455,
                    "userName":"胡杰",
                    "age":35,
                    "birthday":1425520800000
                },
                {
                    "userCode":80099,
                    "userName":"张三丰",
                    "age":110,
                    "birthday":1425525800000
                }
    ]
}
```

#####*建议推广的分页实现（前提需要产品同意；获得员工列表）*
```json
[
    {
        "userCode":86455,
        "userName":"胡杰",
        "age":35,
        "birthday":1425520800000
    },
    {
        "userCode":80099,
        "userName":"张三丰",
        "age":110,
        "birthday":1425525800000
    }
]
```

`此分页实现的优点：`
> - 性能更高
> - 代码更简洁，配合sort，一个比较运算符加一个 Limit/Top 即可
> - 更容易去除业务耦合，可以在内存中剔除不合理的数据

`此分页实现的缺点：`
> - 每一页返回的数据总量往往不符合预期

`此分页方案目前在朋友圈、微信等SNS社交网站有广泛使用`

#####*返回基础数据类型（获得指定员工的年龄）*
```html
35
```

`原则就是：调用接口的时候，只要正常，返回的结果就会符合预期，直接用即可`

### 利用httpStatus来预判业务是否正常

`大家都知道responseBody是一次request返回的最顶层内容形态，所以能直接用 httpStatus 来做预判肯定是效率更高啦~ `

### 版本控制

每一次api 发布后，我们无法保证有多少人悄悄记录了下来更无法保证未来的某事某刻会不会有人来调用。 那么为了保证我们 api（服务）的持续可用性，必须要加入版本控制。

>建议如下
>>api 发布后，结构永不变更，包括字段名与字段类型
>>在url中体现版本号，比如 `fy.dooioo.com/api/v3/xxxxx`
>>每一个版本最好有独立的 `controller/model/service` 等，用开发成本来保障api稳定

##增值服务

###常见的httpStatus（status code）

> `200 ok  - 成功返回状态，对应，GET,PUT,PATCH,DELETE.`
> `400 bad request   - 请求参数异常、可对应 IllegalArgumentException`
> `401 unauthorized   - 未授权,目前已被 openApi 的 token 授权占用，慎用`
> `403 forbidden   - 用户没有权限。`
> `404 not found - 请求的资源不存在。具体获得某工号数据，但是不存在时返回`
> `405 method not allowed - 该http方法不被允许。`
> `415 unsupported media type - 请求类型错误、特指一些多媒体数据`
> `500 internet Server Error - 服务异常，各种运行时异常均可用`

> `555 business error - 我们特定的业务异常码、用于除以上情况描述外的所有异常`

<span id="errorHandler"></span>
*所有的异常，建议均提供标准的异常返回体，建议格式如下*

```json
{
    "code":195,                       -- 业务方提供的code，用于调用方自己使用
    "message":"某乱七八糟的异常"        -- 业务方提供的标准消息，偷懒可用
}
```


## 写在最后

- 如果是使用spring 框架开发的话，非常建议用 spring 4.1 之后的版本， ResponseEntity类增加了很多非常方便的方法， 虽然 此类在 3.0.2 就已经有了
- 返回结果输出 json/基础数据类型 的时候注意编码问题，一个类型是 application/json,一个默认是 text/plain。