# 🚀 Google Cloud Function in Java (Maven)

## 📌 Overview
This is a **Java-based Google Cloud Function** that:
- Accepts an HTTP request.
- Extracts a **query parameter** (`name`).
- Returns a personalized **greeting** message.
- Can be **Run locally**, **Debugged in IDE**, and **Deployed to GCP**.

## 🚀 Prerequisites
Ensure you have the following installed:
- **Java 17+** (`java -version`)
- **Maven** (`mvn -version`)
- **Google Cloud SDK** (`gcloud version`)
- **GCP Project Configured** (`gcloud init`)

## 🏃 Running, Testing, Deploying, Debugging, and Deleting the Function

## Build the Project
mvn clean package

## Run the Function Locally
mvn function:run "-Drun.functionTarget=org.example.HelloWorldFunction"


## Test the Function Locally
curl "http://localhost:8080/?name=Java"
===================
PS C:\Users\shamians> curl "http://localhost:8080/?name=Java"

Security Warning: Script Execution Risk
Invoke-WebRequest parses the content of the web page. Script code in the web page might be run when the page is parsed.
      RECOMMENDED ACTION:
      Use the -UseBasicParsing switch to avoid script code execution.

      Do you want to continue?

[Y] Yes  [A] Yes to All  [N] No  [L] No to All  [S] Suspend  [?] Help (default is "N"): Y


StatusCode        : 200
StatusDescription : OK
Content           : {72, 101, 108, 108...}
RawContent        : HTTP/1.1 200 OK
                    Transfer-Encoding: chunked
                    Date: Mon, 09 Mar 2026 14:20:49 GMT
                    Server: Jetty(9.4.26.v20200117)

                    Hello, Java! Welcome to Google Cloud Functions.
Headers           : {[Transfer-Encoding, chunked], [Date, Mon, 09 Mar 2026 14:20:49 GMT], [Server, Jetty(9.4.26.v20200117)]}
RawContentLength  : 47
===========================================

## Enable Cloud Functions and Cloud Run API
gcloud services enable cloudfunctions.googleapis.com
gcloud services enable run.googleapis.com

## Deploy the Function to Google Cloud
gcloud functions deploy helloFunction --runtime java17 --trigger-http --allow-unauthenticated --entry-point org.example.HelloWorldFunction --region us-central1



## Get the Function URL
gcloud functions describe helloFunction

## Test the Deployed Function
curl "https://us-central1-YOUR_PROJECT_ID.cloudfunctions.net/helloFunction?name=John"
https://us-central1-projectforpoc-489612.cloudfunctions.net/helloFunction

## Delete the Function from Google Cloud
gcloud functions delete helloFunction --region us-central1



# List of all executed commands

Id CommandLine
  -- -----------
   1 cd C:\Users\shamians\Downloads\gcp-cloud-function-main.zip\gcp-cloud-function-main
   2 ls
   3 cd .\Downloads\gcp-cloud-function-main.zip\gcp-cloud-function-main
   4 mvn
   5 pwd
   6 ls
   7 cd .\Downloads\
   8 ls
   9 cd gcp-cloud-function-main.zip\
  10 cd gcp-cloud-function-main.zip
  11 cd C:\Users\shamians\eclipse-workspace\JavaProjectTest\gcp-cloud-function-main.zip_expanded
  12 mvn function:run mvn function:run "-Drun.functionTarget=org.example.HelloWorldFunction"
  13 ls
  14 cd .\gcp-cloud-function-main\
  15 ls
  16 mvn function:run mvn function:run "-Drun.functionTarget=org.example.HelloWorldFunction"

  30 mvn function:run "-Drun.functionTarget=org.example.HelloWorldFunction"
  31 mvn function:run "-Drun.functionTarget=org.example.HelloWorldFunction"
  32 gcloud functions deploy helloFunction --runtime java17 --trigger-http --allow-unauthenticated --entry-point org.example.Hell...
  33 gcloud functions describe helloFunction
  34 gcloud functions delete helloFunction --region us-central1