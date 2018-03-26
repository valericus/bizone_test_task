Application that walks through authorization log and tries to find some 
suspicious activity: multpile logins from same IP for given period of time.

Algorithm uses simple `groupBy` methon common for Scala collections.

# Prerequisites

You need installd [SBT](https://www.scala-sbt.org/) 1.0+ and JRE 8+ to run this.

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