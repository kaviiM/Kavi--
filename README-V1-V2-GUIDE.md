# V1 -> V2 - Visual + Text Change - Full Guide

## Enna Change Pannom?

| Edam | V1 (BLUE) | V2 (GREEN) |
|---|---|---|
| Browser Card Color | BLUE #3498db | GREEN #2ecc71 |
| Badge | VERSION 1 - BLUE | VERSION 2 - GREEN |
| Text /api/health | Version 1 - Hello Everyone... Im Healthy | Version 2 - Updated! Automation Success - Jenkins Deploy Worked! |
| application.yml app.version | V1 | V2 |
| index.html Heading | Version 1 | Version 2 |

## Step 1 - V1 Deploy Pannu (First)

1. Zip extract pannu, VS Code la open pannu
2. Ippo irukkurathu V2. V1 paakanum na:
   - V1-Backup/TestingController-V1.java la irukkurathu copy panni TestingController.java la potu
   - V1-Backup/index-V1-BLUE.html concept paaru - index.html la BLUE aakku
   - application.yml la app.version: V1 nu maathu
3. Manual:
```
mvn clean install -DskipTests=true
docker build --no-cache -t san2-calcus .
docker rm -f con2-san-calcus
docker run -d -p 8097:8090 --name=con2-san-calcus san2-calcus
```
4. Browser: http://localhost:8097/
   -> BLUE Card + VERSION 1 + Old Text theriyum
   -> http://localhost:8097/api/health -> V1 Text theriyum

## Step 2 - Change Pannu - V1 -> V2

VS Code la 3 Edam mattum maathu:

### A. TEXT LEVEL - TestingController.java
```java
// V1:
"Version 1 - Hello Everyone..."
// V2:
"Version 2 - Updated! Automation Success - Jenkins Deploy Worked!"
"version", "V2"
"color", "GREEN"
```

### B. VISUAL LEVEL - src/main/resources/static/index.html
```html
<!-- V1: background #e3f2fd, border-top #3498db, badge BLUE -->
<!-- V2: background #e8f5e9, border-top #2ecc71, badge GREEN -->
<div class="badge">VERSION 2 - GREEN</div>
<h1>Version 2 - Updated! Automation Success</h1>
```

### C. VERSION - application.yml
```yaml
app:
  version: V2
  message: "Version 2 - Updated! Automation Success"
```

## Step 3 - Automation - Jenkins la Deploy Pannu

1. GitHub la Push pannu:
```
git add .
git commit -m "Update V1 to V2 - Green + New Text"
git push origin main
```
2. Jenkins -> Job1.1-Simplebyte -> Build Now
   - Freestyle na: Jenkins-Freestyle-V1-V2.txt la irukkurathu ORU Step
   - Pipeline na: Jenkinsfile use pannu
3. Jenkins Log la paaru: BUILD SUCCESS + docker build --no-cache + Tomcat started

## Step 4 - Visual Check - Browser Refresh Pannu!

- http://localhost:8097/ -> GREEN Card + VERSION 2 theriyanum!
- http://localhost:8097/api/health -> V2 Text theriyanum!
- Hard Refresh: Ctrl + Shift + R (Cache la Pazhaya V1 iruntha pogum)

## Input Kudutha Change Theriyanuma?

Aama! Example:
- TestingController.java la "message" ah un input text ah maathu: "Kavi Version - Vanakkam!"
- index.html la Heading ah maathu
- Push + Jenkins Build -> Browser la un input text thaan theriyum!

## Rollback - V2 pudikalana V1 ku Poga

```
git log --oneline
git revert HEAD
git push origin main
Jenkins Build Now -> BLUE V1 thirumba varum!
```

Port: Inside 8090, Outside 8097, Java 17 - Ellam same, maaraathu. Maarurathu mattum Visual + Text + Version.
