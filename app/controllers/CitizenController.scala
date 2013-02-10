package controllers

import play.api._
import play.api.mvc._
import play.api.data.Form
import play.api.data.Forms._
import model.Citizen


object CitizenController extends Controller {

  
  val citizenForm = Form(
     mapping(
    "firstname" -> text,
    "lastname" -> text,
    "address" -> text,
    "pesel" -> text)
    ((firstname, lastname, address, pesel) => Citizen(firstname, lastname, address, pesel))
    (citizen => Some(citizen.firstname, citizen.lastname, citizen.address, citizen.pesel)))
  
  
  def form = Action {
    Ok(views.html.index(citizenForm))
  }
  
  def submit = Action {
    Ok("Submit")
  }
  
}