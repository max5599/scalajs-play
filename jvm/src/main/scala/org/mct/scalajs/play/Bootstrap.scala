package org.mct.scalajs.play

import com.typesafe.scalalogging.LazyLogging
import play.api.libs.json.Json
import play.api.mvc._
import play.api.routing.sird._
import play.core.server.AkkaHttpServer

object Bootstrap extends App with LazyLogging {

  val server = AkkaHttpServer.fromRouterWithComponents() { components =>
    import Results._
    import components.{defaultActionBuilder => Action}
    {
      case POST(p"/api/hello") => Action {
        Ok(Json.obj("hello" -> "world"))
      }
    }
  }

  logger.info("Starting server with port {}", server.httpPort.get)

}
