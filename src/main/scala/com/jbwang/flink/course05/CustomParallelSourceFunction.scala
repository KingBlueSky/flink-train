package com.jbwang.flink.course05

import org.apache.flink.streaming.api.functions.source.{ParallelSourceFunction, SourceFunction}

/**
 * scala的自定义source
 */
class CustomParallelSourceFunction extends ParallelSourceFunction[Long] {

    var count = 1
    var isRunning = true

    override def cancel(): Unit = isRunning = false

    override def run(ctx: SourceFunction.SourceContext[Long]): Unit = {
        while (isRunning) {
            ctx.collect(count)
            count += 1
            Thread.sleep(1000)
        }
    }
}
