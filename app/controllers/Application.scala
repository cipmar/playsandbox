package controllers

import play.api.libs.iteratee.Enumerator
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.Cookie
import play.api.mvc.ResponseHeader
import play.api.mvc.SimpleResult

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Index page")).withCookies(Cookie("a", "b"))
  }

  def request1 = Action {
    SimpleResult(
      header = ResponseHeader(200, Map(CONTENT_TYPE -> "text/plain")),
      body = Enumerator("text/plain request"))
  }

  def request2 = Action {
    SimpleResult(
      header = ResponseHeader(200, Map(CONTENT_TYPE -> "application/json")),
      body = Enumerator("{foo: 1, bar: 2}"))
  }

  def request3 = Action {
    Ok(views.html.request3("A content"))
  }
}