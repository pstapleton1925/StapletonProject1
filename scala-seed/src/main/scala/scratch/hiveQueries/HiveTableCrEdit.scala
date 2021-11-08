package scratch.hiveQueries

object HiveTableCrEdit {
  def createNew: Unit = {
      val newTableString = {
          "create table " + tableName + " (key string, value string) row format delimited fields terminated by ','"
      }

  }
}

/*
create table if not exists json_table(
 data struct:<id : String, text : String>
 */