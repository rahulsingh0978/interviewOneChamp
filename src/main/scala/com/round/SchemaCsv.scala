package com.round


import org.apache.spark.sql.types.{ LongType, StringType, StructField, StructType}

object SchemaCsv extends Serializable {

  private val activityData =
    StructType(
        StructField("person_id",StringType, false) ::
        StructField("datetime",StringType, false) ::
        StructField("floor_level",StringType, false) ::
        StructField("building",StringType, false) :: Nil)

  /**
   * @return the structure for schema
   */
  val getStructure = () => activityData;
}
