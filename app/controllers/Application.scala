package controllers

import play.api.data._
import play.api.data.Forms._
import play.api.libs.iteratee.Enumerator
import play.api.mvc.Action
import play.api.mvc.Controller
import play.api.mvc.Cookie
import play.api.mvc.ResponseHeader
import play.api.mvc.SimpleResult

object Application extends Controller {

  val ordersList = List(
    Order(1, "112", "Product 1", 21, 2.1),
    Order(2, "134", "Product 2", 12, 22.1),
    Order(3, "165", "Product 5", 13, 12.1),
    Order(4, "213", "Product 7", 22, 52.1),
    Order(5, "651", "Product 9", 19, 32.21))

  val orderForm = Form(
    tuple(
      "customerId" -> text,
      "itemName" -> text,
      "itemQty" -> text,
      "itemPrice" -> text))

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

  def orders = Action {
    Ok(views.html.orders(ordersList))
  }

  def orderAdd = Action {
    Ok(views.html.orderAdd(form(Order(1, "", "", 1, 1.1))))
  }

  def orderAddSubmit = Action {
    Ok(views.html.orders(ordersList))
  }
}
