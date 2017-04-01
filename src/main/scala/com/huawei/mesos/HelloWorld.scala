package com.huawei.mesos

import org.apache.mesos.MesosSchedulerDriver
import org.apache.mesos.Protos.FrameworkInfo

object HelloWorld {
  def main(args: Array[String]): Unit = {
    val framework = FrameworkInfo.newBuilder
      .setName("HelloWorld")
      .setUser("zgd")
      .setRole("*")
      .setCheckpoint(false)
      .setFailoverTimeout(0.0d)
      .build()

    //create instance of schedule and connect to mesos
    val scheduler = new MyScheduler
    //submit shell commands
    scheduler.submitTasks(args: _*)
    val mesosURL = "9.96.101.32:5050"
    val driver = new MesosSchedulerDriver(scheduler, framework, mesosURL)
    //run the driver
    driver.run()
  }
}
