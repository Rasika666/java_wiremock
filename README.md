# java_wiremock

## request

---
path: auth/yrequest (POST)
```json
{
  "correlationId":"8801866752325",
  "appId":"APP_000417",
  "appName":"yblo1",
  "spId":"SPP_000010",
  "spName":"mig1",
  "operator":"robi",
  "subscriberId":"8801865401265",
  "data":{"subscription-charges-msg":"Subscription to this application is free."}
}
```

Response
```json
{
	"statusCode":"S1000",
	"statusDescription":"Success",
	"correlationId":"8801866752328",
	"appId":"APP_000417",
	"subscriberId":"8801865401268",
	"operator":"robi"
}
```
---
path: subscription_cgw_wrapper/production/ChargeSpecificAmount.php?appid=hsenidmobile&apppass=hsenidmobile&ano=8801819199999&bno=21213&serviceid=21213_BLAPPStore_4_daily_0001_001&subscriptiongroupid=21213_BLAPPStore_4_daily_0001_001&subscriptionrootid=21213_BLAPPStore_4_daily_0001&tid=921090219530000002&type=ondemand

`GET`

Response

```json
921090219530000002::9999::Other Any kind of Error
```


---

