package com.round

import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}

object OneChampion {
  private val csvSchema = SchemaCsv.getStructure();

  def main(args: Array[String]): Unit = {

    if (args == null || args.length != 2) {
      throw new IllegalArgumentException("command line arguments length must be 2");
    }

    val readPath = args(0);
    val writePath = args(1);

    val spark = SparkSession
      .builder()
      .appName("one champ")
      .master("local[2]")
      .getOrCreate();

    val df1: DataFrame = spark.sqlContext.read.schema(csvSchema).option("header","true").format("csv").load(readPath)
    df1.show(3)
    df1.write.json(writePath)
  }
}
