# Command to set service account key


Service Account Key 
If you prefer using a dedicated Service Account, follow these steps:
Download the JSON key:
Go to the GCP Console Service Accounts page.
Select your Service Account → Keys → Add Key → Create new key (JSON).
Point your environment to the file:


Windows (CMD):
cmd
set GOOGLE_APPLICATION_CREDENTIALS=C:\path\to\your-key.json

C:\Users\shamians>set GOOGLE_APPLICATION_CREDENTIALS=C:\Users\shamians\eclipse-workspace\JavaProjectTest\GCPStorage.zip_expanded\GCPStorage\src\main\resources\serviceaccountKey.json


# How to Fix the Path
# In Spring Boot, when a file is inside src/main/resources, you must use the classpath: prefix so the 

spring.cloud.gcp.credentials.location=classpath:serviceaccountKey.json

# Send request URL to test API

Operation	HTTP Method	URL Example
Create	POST	http://localhost:9090/bucket/upload?fileName=test.txt&content=Hello
Read	GET	http://localhost:9090/bucket/read?fileName=test.txt
Update	PUT	http://localhost:9090/bucket/update?fileName=test.txt&newContent=NewData
Delete	DELETE	http://localhost:9090/bucket/delete?fileName=test.txt


# To Fix below permission issue while accessing the bucket from Java code

t{ "error": { "code": 403, "message": "shamim-service-account@projectforpoc-489612.iam.gserviceaccount.com does not have storage.objects.create access to the Google Cloud Storage object. Permission 'storage.objects.create' denied on resource (or it may not exist).", "errors": [ { "message": "shamim-service-account@projectforpoc-489612.iam.gserviceaccount.com does not have storage.objects.create access to the Google Cloud Storage object. Permission 'storage.objects.create' denied on resource (or it may not exist).", "domain": "global", "reason": "forbidden" } ] }

# Steps to fix

#The Fix: Grant IAM Roles
You need to give your service account (shamim-service-account@...) the correct permissions in the Google Cloud Console:
Go to IAM & Admin > IAM.
Find your service account: shamim-service-account@projectforpoc-489612.iam.gserviceaccount.com.
Click the Edit (pencil icon) button.
Click Add Another Role and search for:
Storage Object Admin (Full CRUD: Create, Read, Update, Delete)
OR Storage Object Creator (Only for uploads).
Click Save.