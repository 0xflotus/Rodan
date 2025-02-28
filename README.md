
# Rodan Telecom Exploitation Framework

<!---
<img src="res/banner.png" align="right" width="200" height="212">
-->

### Disclaimer
Rodan framework is provided so that you can test your systems against threats, understand the nature of these threats, and protect your own systems from similar attacks. Do not attempt to violate the law using Rodan. If this is your intention, then LEAVE NOW!

Any actions and/or activities related to the the uses of Rodan is solely your responsibility. The misuse of Rodan can result in criminal charges brought against the persons in question. The authors and Etisalat Egypt will not be held responsible in the event any criminal charges be brought against any individuals misusing the information in this website to break the law.

## Introduction

Rodan is a telecom signaling exploitation framework created and maintained by 
[Etisalat Egypt][et] Research Labs (E-Labs). This framework includes a suite of 
modules that enable users to exploit vulnerabilities in the signaling protocols 
used by mobile operators. 
Rodan currently supports SS7 and Diameter protocols with plans to support GTP and SIP.

## Authors
* [Ayman ElSherif][ayman]

## Features

* Network and Subscriber Information Diclosure.
* Location Tracking.
* SMS Interception.
* Call Redirection.
* Fraud.
* GT/Host Brute Forcing.
* Advanced Filtering Bypass:
  * E.214 Numbering Plan
  * Malfrmed ACN.
  * Substitution of Operation Code Tag.
  * Double MAP.
  * Calling Party/Origin Host Spoofing.
* SS7 Simulation Network.

Rodan has a look and feel similar to the Metasploit Framework, reducing the learning curve for leveraging the framework.

**NOTE:** Knowlege of SS7 and Diameter signaling protocols is required to use Rodan framework

# Installation instructions

#### Supported OS:
* Linux OS

## 1. Download source code

#### Download and extract the source:
[Download from GitHub][master]
```bash
$ unzip rodan-master
$ cd rodan-master
```
**NOTE:** Instead of downloading the compressed source, you may instead want to clone the GitHub 
repository: `git clone https://github.com/Etisalat-Egypt/Rodan.git`

## 2. Build

### Build using Docker
The easiest way to build Rodan is using provided Docker build container, and use it with the included simulation network.

#### Prerequisites
* [Docker Runtime][docker]
* [Docker Compose][docker-compose]
* [Manage Docker as a non-root User][docker-non-root]

```bash
$ cd build/scripts
$ chmod +x build-docker.sh
$ ./build-docker.sh
```

### Standalone build
To create the latest development build from this source repository:

#### Install build tools:
* [JDK 17 64-bit][jdk17]
* [Maven 3][maven]

#### Install Linux SCTP tools:
```bash
$ sudo apt install lksctp-tools
```

#### Disable Maven's default http removing or commenting out maven-default-http-blocker element in settings.xml.
```xml
  <mirror>
      <id>maven-default-http-blocker</id>
      <mirrorOf>external:http:*</mirrorOf>
      <name>Pseudo repository to mirror external repositories initially using HTTP.</name>
      <url>http://0.0.0.0/</url>
      <blocked>true</blocked>
    </mirror>
  </mirrors>
```

#### Build framework and stack extentions: 
```bash
$ cd build/scripts
$ chmod +x build-standalone.sh
$ ./build-standalone.sh
```

## 3. Run

### Run using Docker

#### Edit yaml configuration files in build/config folder
#### Run startup script:
```bash
$ cd build/scripts
$ chmod +x start-docker.sh
$ ./start-docker.sh
```

#### Open a new terminal and attach to Intruder container
```bash
$ docker attach intruder
```


### Run as a standalone
#### Edit yaml configuration files in build/config folder
#### Run:
```bash
$ cd build/scripts
$ chmod +x start-standalone.sh
$ ./start-standalone.sh
```


[et]: https://www.etisalat.eg
[jdk17]: https://openjdk.java.net/projects/jdk7/
[maven]: https://maven.apache.org/download.cgi
[master]: https://codeload.github.com/Etisalat-Egypt/Rodan/zip/refs/heads/main
[docker]: https://docs.docker.com/engine/install/
[docker-compose]: https://docs.docker.com/compose/install/
[docker-non-root]: https://docs.docker.com/engine/install/linux-postinstall/#manage-docker-as-a-non-root-user
[ayman]: https://github.com/AymanElSherif
