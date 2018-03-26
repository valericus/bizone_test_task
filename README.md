Application that walks through authorization log and tries to find some 
suspicious activity: multpile logins from same IP for given period of time.

Algorithm uses simple `groupBy` methon common for Scala collections.

# Prerequisites

You need installed [SBT](https://www.scala-sbt.org/) 1.0+ and JRE 8+ to run this.

# Input data

Input data should be formatted as CSV file with user name, IP and log in time.

```csv
"boyboy11","94.254.198.11","2015-11-30 23:16:47"
"Wiola193","94.254.198.11","2015-11-30 23:17:25"
"Stefan123","94.254.198.11","2015-11-30 23:17:21"
"username25","50.160.168.157","2015-11-30 23:17:48"
"trashx","50.160.168.157","2015-11-30 23:17:56"
"Clear94","31.162.217.43","2015-11-30 23:17:58"
"monsterlabel","179.233.26.140","2015-11-30 23:18:32"
```

# Output data

Result will be formatted as CSV like this.

```csv
94.254.198.11,2015-11-30 23:16:47,2015-11-30 23:17:25,"boyboy11:2015-11-30 23:16:47,Wiola193:2015-11-30 23:17:25,Stefan123:2015-11-30 23:17:21"
50.160.168.157,2015-11-30 23:17:48,2015-11-30 23:17:56,"username25:2015-11-30 23:17:48,trashx:2015-11-30 23:17:56"
```

As you can see it contains IPs, start and end of each series and
detail of each event (username and timestamp).

# How to run

## Compile and assemble

```bash
sbt assembly
```

This will give us so called "fat JAR" that contains all required classes 
to start application. You can find it under 
`target/scala-2.11/bi_zone-assembly-0.1.0.jar`

## Run

```bash
java -jar target/scala-2.11/bi_zone-assembly-0.1.0.jar <input_file> <output_file>
```

The command starts application to read data from `<input_file>` CSV and to
write analisys result to `<output_file>`. You can also add optional third
parameter that specifies duration of intervals to analyze in second. Default value 
is 3600 (1 hour). 

```bash
java -jar target/scala-2.11/bi_zone-assembly-0.1.0.jar <input_file> <output_file> 60
```