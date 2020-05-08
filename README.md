# Spark_WordCount
Spark WordCount Example in Different Spark Modes


# Spark

```
val sparkConf = new SparkConf().setMaster("local[*]").setAppName("SparkWordCountApp")//local mode
val sc = new SparkContext(sparkConf)
```

## What is SparkConf and SparkContext

Sparkconf is the class which gives you the various option to provide configuration parameters.

Sparkcontext is the entry point for spark environment. For every sparkapp you need to create the sparkcontext object. In spark 2 you can use sparksession instead of sparkcontext.

setMaster and setAppName are the two properties that must be configured

```
import org.apache.spark.{SparkConf, SparkContext}

val conf = new SparkConf()
             .setMaster("local[2]")
             .setAppName("CountingSheep")
val sc = new SparkContext(conf)
val rdd = sc.textFile("file:///Users/xiangluo/Documents/GitHub/Spark_WordCount/data/input.txt")
```
```
import org.apache.spark.sql.SparkSession

val spark = SparkSession
  .builder()
  .appName("SparkWordCountApp")
  .master("local[*]")
  .getOrCreate()
val rdd = spark.sparkContext.textFile("file:///Users/xiangluo/Documents/GitHub/Spark_WordCount/data/input.txt")

```
Note that we run with local[2], meaning two threads. local[N] to run locally with N threads. local[*] Run Spark locally with as many worker threads as logical cores on your machine.

## flatmap and map

A map is a transformation operation in Apache Spark. It applies to each element of RDD and it returns the result as new RDD.

A flatMap is a transformation operation. It applies to each element of RDD and it returns the result as new RDD. It is similar to Map, but FlatMap allows returning 0, 1 or more elements from map function. 

map(func) Return a new distributed dataset formed by passing each element of the source through a function func.

flatMap(func) Similar to map, but each input item can be mapped to 0 or more output items (so func should return a Seq rather than a single item).

The transformation function: map: One element in -> one element out. flatMap: One element in -> 0 or more elements out (a collection).


# Maven

## Version
```
    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <encoding>UTF-8</encoding>
        <scala.tools.version>2.11</scala.tools.version>
        <scala.version>2.11.12</scala.version>
        <spark.version>2.4.5</spark.version>
        <hadoop.version>2.7.7</hadoop.version>
    </properties>
```

## Repository

mavenCentral  http://mvnrepository.com/

```
    <repositories>
        <repository>
            <id>central</id>
            <name>Central Repository</name>
            <url>https://repo.maven.apache.org/maven2</url>
            <layout>default</layout>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>
```

## groupId, artifactId and version

groupId uniquely identifies your project across all projects. A group ID should follow Java's package name rules. This means it starts with a reversed domain name you control. For example,

org.apache.maven, org.apache.commons

Maven does not enforce this rule. There are many legacy projects that do not follow this convention and instead use single word group IDs. However, it will be difficult to get a new single word group ID approved for inclusion in the Maven Central repository.

You can create as many subgroups as you want. A good way to determine the granularity of the groupId is to use the project structure. That is, if the current project is a multiple module project, it should append a new identifier to the parent's groupId. For example,

org.apache.maven, org.apache.maven.plugins, org.apache.maven.reporting

artifactId is the name of the jar without version. If you created it, then you can choose whatever name you want with lowercase letters and no strange symbols. If it's a third party jar, you have to take the name of the jar as it's distributed.
eg. maven, commons-math

version if you distribute it, then you can choose any typical version with numbers and dots (1.0, 1.1, 1.0.1, ...). Don't use dates as they are usually associated with SNAPSHOT (nightly) builds. If it's a third party artifact, you have to use their version number whatever it is, and as strange as it can look. For example,
2.0, 2.0.1, 1.3.1

# Java's package name rules

Naming Conventions
Package names are written in all lower case to avoid conflict with the names of classes or interfaces.

Companies use their reversed Internet domain name to begin their package names—for example, com.example.mypackage for a package named mypackage created by a programmer at example.com.

Name collisions that occur within a single company need to be handled by convention within that company, perhaps by including the region or the project name after the company name (for example, com.example.region.mypackage).

Packages in the Java language itself begin with java. or javax.

In some cases, the internet domain name may not be a valid package name. This can occur if the domain name contains a hyphen or other special character, if the package name begins with a digit or other character that is illegal to use as the beginning of a Java name, or if the package name contains a reserved Java keyword, such as "int". In this event, the suggested convention is to add an underscore. For example:

| Domain Name  | Package Name Prefix |
| ------------- | ------------- |
| hyphenated-name.example.org	| org.example.hyphenated_name  |

# Spark WordCount Example

Input: File 

Requirement: Count the frequence of each word in the file

Output: File
