package controllers

case class Order(
  orderId: Int,
  customerId: String,
  itemName: String,
  itemQry: Int,
  itemPrice: Double) {

}

