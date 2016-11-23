RUN
--------------------------
### 1. start authserver and enroll service  
	
	../authserver/gradlew build  
	./gradlew build  
	docker-compose up
	
### 2. get auth token

	curl --insecure -H "Authorization: Basic $(echo -n 'acme:acmesecret' | base64)" https://localhost:8443/uaa/oauth/token -d grant_type=password -d username=user -d password=password -v

acme & acmesecret is a predefined client in authserver
user & password is a predefined user

Response
```
{"access_token":"ACCESS_TOKEN","token_type":"bearer","refresh_token":"REFRESH_TOKEN","expires_in":43199,"scope":"openid","jti":"1da538e3-afb7-45dc-a318-0e4c6f578685"}
```

**copy the access token for next step**
### 3. enroll

	curl -H 'Content-type: application/json' -H 'Authorization: Bearer ACCESS_TOKEN' -X POST http://localhost:8080/enroll/ -d '{"name": "Tom", "phone": "13201234567", "eventId": "1"}'

**Replace ACCESS_TOKEN with real token which you get from step 2.**


