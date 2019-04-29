import akka.actor.ActorSystem
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.{HttpApp, Route}
import com.lightbend.cinnamon.akka.http.scaladsl.server.EndpointNameDirective.endpointName

object CinnamonBug {
  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("system")
    implicit val executionContext = system.dispatcher

    val app = new HttpApp {
      override protected def routes: Route =
        path("foo") {
          parameter('p) {
            case "a" =>
              endpointName("a-endpoint") {
                reject
              }
            case "b" =>
              endpointName("b-endpoint") {
                complete(StatusCodes.OK)
              }
          }
        }
    }

    app.startServer("localhost", 8080, system)
  }
}
