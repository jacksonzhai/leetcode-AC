package com.realtime.spark.stream.utils

import java.sql.Connection

import com.jolbox.bonecp.{BoneCP, BoneCPConfig}
import org.slf4j.LoggerFactory

object MysqlConnectionPool {
  val logger = LoggerFactory.getLogger(this.getClass)
  private val connectionPool = {
    try {
      Class.forName("com.mysql.jdbc.Driver")
      val config = new BoneCPConfig()
      config.setJdbcUrl("")
      config.setUser("")
      config.setPassword("")
      config.setLazyInit(true)
      config.setMinConnectionsPerPartition(3)
      config.setMaxConnectionsPerPartition(5)
      config.setPartitionCount(5)
      config.setCloseConnectionWatch(true)
      config.setLogStatementsEnabled(false)
      config.setConnectionTimeoutInMs(1000 * 1)
      config.setQueryExecuteTimeLimitInMs(1000 * 2)
      Some(new BoneCP(config))
    } catch {
      case exception: Exception => {
        logger.error("Error in creation of connection pool" + exception.printStackTrace())
        None
      }
    }
  }

    def getConnection: Option[Connection] = {
      connectionPool match {
        case Some(connPool) => Some(connPool.getConnection)
        case None => None
      }
    }

    def closeConnection(connection: Connection): Unit = {
      if (!connection.isClosed) {
        connection.close()

      }
    }


}
