package de.upb.dbis.baas.composition

import de.upb.dbis.baas.IOMapping
import de.upb.dbis.baas.Similarity
import de.upb.dbis.baas.annotator.SpecificationLoader
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale
import org.apache.jena.ontology.OntModelSpec
import org.apache.jena.rdf.model.Model
import org.apache.jena.rdf.model.ModelFactory
import de.upb.dbis.baas.BaasFactory

class MatchingEvaluation extends Matching{
	
	Model model;
	

	
	static def void main(String[] args) {
		new MatchingEvaluation().evaluate()
	}
	
	def evaluate(){
		
		model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);
		model.read("data/schema.owl.nt");
		
		var lufthansa = new SpecificationLoader().load("data/parameter_matcher/Lufthansa.yaml");
		
		var hertz = new SpecificationLoader().load("data/parameter_matcher/Hertz.yaml");
		
		val op1 = lufthansa.operations.findFirst[o|o.operationId.equals("OperationsSchedulesFromDateTimeByOriginAndDestinationGet")];
		val op2 = hertz.operations.findFirst[o|o.operationId.equals("vehicles")];

		System.out.println('''lufthansa inputs: «op1.ios.filter[i|i.type.equals("input")].size»''');
		System.out.println('''lufthansa outputs: «op1.ios.filter[i|i.type.equals("output")].size»''');

		System.out.println('''hertz inputs: «op2.ios.filter[i|i.type.equals("input")].size»''');
		System.out.println('''hertz outputs: «op2.ios.filter[i|i.type.equals("output")].size»''');

		
//		for(IO io:op2.ios){
//			
//			if(io.type.equals("input")){
//				System.out.println('''op1.ios.findFirst[i|i.name.equals("«io.name»") && i.type.equals("input")]''');
//			}
//			else{
//				
//				System.out.println('''op1.ios.findFirst[i|i.jsonPath?.equals("«io.jsonPath»") && i.type.equals("output")]''');
//			}
//		}	
		
		op1.ios.findFirst[i|i.name.equals("origin") && i.type.equals("input")].subject = (wrap("Airport"));
		
		op1.ios.findFirst[i|i.name.equals("destination") && i.type.equals("input")].subject = (wrap("Airport"));
		
		op1.ios.findFirst[i|i.name.equals("fromDateTime") && i.type.equals("input")].subject = wrap("Event")
//		op1.ios.findFirst[i|i.name.equals("Accept") && i.type.equals("input")]
//		op1.ios.findFirst[i|i.name.equals("directFlights") && i.type.equals("input")]
//		op1.ios.findFirst[i|i.name.equals("limit") && i.type.equals("input")]
//		op1.ios.findFirst[i|i.name.equals("offset") && i.type.equals("input")]

		
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Arrival.AirportCode") && i.type.equals("output")].subject =wrap("Airport");
		
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].TotalJourney.Duration") && i.type.equals("output")].subject = (wrap("Duration"));
				
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Arrival.Terminal.Name") && i.type.equals("output")]
		
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Arrival.ScheduledTimeLocal.DateTime") && i.type.equals("output")]

		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Departure.ScheduledTimeLocal.DateTime") && i.type.equals("output")]
		
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.MarketingCarrier.FlightNumber") && i.type.equals("output")].subject = (wrap("Flight"));
		
//		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Meta.Link.[*].@Href") && i.type.equals("output")]
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.MarketingCarrier.AirlineID") && i.type.equals("output")].subject = (wrap("Airline"));
		
		
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Details.DatePeriod.Effective") && i.type.equals("output")]
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Details.DatePeriod.Expiration") && i.type.equals("output")]
//		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Meta.Link.[*].@Rel") && i.type.equals("output")]
//		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Details.DatePeriod.Expiration") && i.type.equals("output")]
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.OperatingCarrier.AirlineID") && i.type.equals("output")].subject = (wrap("Airline"));
		
		
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Equipment.AircraftCode") && i.type.equals("output")].subject = (wrap("Vehicle"));
//		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Meta.@Version") && i.type.equals("output")]
		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Departure.AirportCode") && i.type.equals("output")].subject = (wrap("Airport"));
//		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Details.DaysOfOperation") && i.type.equals("output")]
//		op1.ios.findFirst[i|i.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Details.Stops.StopQuantity") && i.type.equals("output")]


		op2.ios.findFirst[i|i.name.equals("buttonFPO") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpDropoffSearchType") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpPickupIsServedBy") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("cdpRadioButton") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("fromLocationSearch") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpPickupSearchType") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("showRentalAgreement") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("href") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("showBothElements") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpPickupStateCode") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("defaultTab") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("militaryClock") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("originalRqCheckBox") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpPickupAutoFill") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpDropoffCountryCode") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("majorAirport") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("selectedCarType") && i.type.equals("input")].subject = wrap("Vehicle")
		op2.ios.findFirst[i|i.name.equals("confirmationNumber") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("arrivingUpdate") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("returnAtDifferentLocationCheckbox") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("dropoffDayStandard") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("corporateRate") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("buttonLIS") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("no1ClubNumber") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("dropoffDay") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("cvNumber") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("checkLIS") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpPickupCountryCode") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("forceResHomePage") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("pcNumber") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("itNumber") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpPickupHasSpecialInstruction") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("cdpField") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("ageSelector") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("redeemPoints") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpPickupOptGoldAnytime") && i.type.equals("input")]
		
		op2.ios.findFirst[i|i.name.equals("pickupDay") && i.type.equals("input")]
		
		op2.ios.findFirst[i|i.name.equals("dropoffLocation") && i.type.equals("input")].subject = wrap("Place")
		
		op2.ios.findFirst[i|i.name.equals("goldAnytimeRes") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("pickupHiddenEOAG") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("lastName") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("memberSelectedCdp") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("typeInRateQuote") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpDropoffAutoFill") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("pickupDayStandard") && i.type.equals("input")]
		
		op2.ios.findFirst[i|i.name.equals("pickupLocation") && i.type.equals("input")].subject = wrap("Place")
		
		op2.ios.findFirst[i|i.name.equals("dropoffHiddenEOAG") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("officialTravel") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("inpDropoffStateCode") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("memberOtherCdpField") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("checkDiscount") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("dropoffTime") && i.type.equals("input")]
		op2.ios.findFirst[i|i.name.equals("checkFPO") && i.type.equals("input")]
		
		op2.ios.findFirst[i|i.name.equals("pickupTime") && i.type.equals("input")]
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.isCitySpecialSelected") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.ccGuaranteed") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.bestRate") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].id") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].total") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.checkFPO") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isPrepay") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.showCurrencyConverterLink") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].carTypeDisplay") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.isCollection") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.inclusions.[*].text") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.suppressEditLink") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.dropoffDateValue") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.showHod24X7Vehicles") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isSeparateTax") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isDigitalWallet") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].noOfMediumSuitcases") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.numberToDisplay") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.walletRetrieveFail") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.prepaidNotice") && i.type.equals("output")]
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.lat") && i.type.equals("output")].subject = (wrap("GeoCoordinates"));
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.rateType") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.showHodMapView") && i.type.equals("output")]
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.currency") && i.type.equals("output")]
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.total") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].call") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.countryCode") && i.type.equals("output")].subject = (wrap("Country"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.inclusions.[*].currency") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].cannotBeQuoted") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].bold") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].vehicleIndex") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.country") && i.type.equals("output")].subject = (wrap("Country"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].policyCode") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].upsellPrice") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.showBothElements") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].icon") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.age") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].automatic") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].prepaidNotice") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.isHod24X7Enabled") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.checkLIS") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].ccGuaranteed") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].name") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupTimeValue") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isRateGuaranteed") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.rentalAgreementLink") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.locationOAGCode") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].creditCardRequired") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].quoteIndex") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.discounts.[*]") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].rateCode") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].carGroup") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].conversionCurrency") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payLater.total") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.inclusions.[*].amount") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.isBlockExclusions") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.suppressEditLink") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].passengers") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].sipp") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].sippDisplay") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].unavailable") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.displaySoldOut") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].vehicleIndex") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].exclusiveItems.[*].value") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isFuelOption") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.citySpecialFound") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].exclusiveItems.[*].name") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.arrivalInfo.desc") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.showOptOutLink") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.checkHodVehiclesAvailability") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.isEuro") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.dropoffDate") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.name") && i.type.equals("output")].subject = (wrap("Place"));
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.fax") && i.type.equals("output")]
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.zip") && i.type.equals("output")].subject = (wrap("PostalAddress"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.state") && i.type.equals("output")].subject =(wrap("State"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.resultInfo.resultCode") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].amenities.[*]") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.rateInfo.balance") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].mileageCapMore") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].rateType") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.exclusions.[*].text") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].vehicleDisclaimerContent") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].name") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.rateCode") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].inclusiveItems.[*].name") && i.type.equals("output")]
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.lon") && i.type.equals("output")].subject = (wrap("GeoCoordinates"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.buttonFPO") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.isAutoShowVehicleDetail") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.baseRates.[*].quantity") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].quantity") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.exclusions.[*].policyCode") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.hours") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.inclusions.[*].policyCode") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].noOfSmallSuitcases") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].isSpecialityVehicle") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.showHodOverlay") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].selectForQuote") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.baseRates.[*].unitRate") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.showRateDetails") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.bannerPosition") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.locationClosed") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].href") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.discountAd") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupDateValue") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupDateStandard") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].allNotAvailableOrSoldout") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].offsell") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].unitRate") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.isDelivery") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].allNotAvailableOrSoldout") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.multiRate") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.optOutLinkDescription") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.rateInfo.approxTotal") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isTATour") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.isPickup") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.buttonLIS") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].exact") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.optOutAction") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].noOfLargeSuitcases") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].mileageCap") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.goldAnytimeRes") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.baseRates.[*].total") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.baseRates.[*].currency") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.isDisplayApproxTotal") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isDisplayInclusionRates") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.addressLine2") && i.type.equals("output")].subject = (wrap("PostalAddress"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.isRedeemPoints") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.addressLine1") && i.type.equals("output")].subject = (wrap("PostalAddress"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.href") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].priced") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].phone") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isTour") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.dropoffTimeValue") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payLater.currency") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.milesNote2") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].currency") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.optOutLinkUrl") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].img") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.displayBannerInList") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].price") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].luggage") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payLater.tax") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].guaranteed") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isApplicantReservation") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.allNotAvailableOrSoldout") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.milesNote1") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isEMEARuleActive") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].currency") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].airConditioning") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.href") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.optOutLinkText") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.city") && i.type.equals("output")].subject = (wrap("City"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].unique") && i.type.equals("output")]
		
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupDate") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].transmission") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.modifyArrivalUrl") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.rateInfo.currency") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.baseRates.[*].duration") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.rqrLink") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.stateCode") && i.type.equals("output")].subject = (wrap("State"));
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isApplicatReservationForConfpage") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.baseRates.[*].durationShort") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].multiRate") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].fuel") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].soldout") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].conversionPrice") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.mapPickupUrl") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.dropoffDateStandard") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].isFlightRequired") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].guarantee") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.currencyConverterLink") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.type") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].prepaid") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].sippIndex") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.pickupLocation.phone") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.modifyUrl") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.leftColumnPrepaid") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].duration") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.prepaidModify") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.rateInfo.paidAmount") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].inclusiveItems.[*].value") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.resultInfo.result") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.iconInfo") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.payNow.tax") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.optOutPrepaidInd") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.showRentalAgreement") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].isUnlimitedMiles") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.isOneWay") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].vto") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.displayBannerAds") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.carRentalGuideDisplay") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.model.vehicles.[*].quotes.[*].fee") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.itinerary.arrivalInfo.type") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.generalInfo.isRateSubjectToChange") && i.type.equals("output")]
		op2.ios.findFirst[i|i.jsonPath?.equals("$.data.rateDetails.optionals.[*].key") && i.type.equals("output")]

		
		var x = match(#[op1, op2])
		var rank = 1
		for(IOMapping mapping : x){

			if(mapping.left.name.equals("destination") && mapping.right.name.equals("pickupLocation")){
				System.out.println('''«rank» destination, pickupLocation ''')
			}
			if(mapping.left.name.equals("fromDateTime") && mapping.right.name.equals("pickupDay")){
				System.out.println('''«rank» fromDateTime, pickupDay ''')
			}
			if(mapping.left.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Arrival.ScheduledTimeLocal.DateTime") && mapping.right.name.equals("pickupDay")){
				System.out.println('''«rank» DateTime, pickupDay ''')
			}			
									
			
			rank++
						
			//System.out.println('''«mapping.score»: «IF mapping.left.type.equals("input")»«mapping.left.name»«ELSE»«mapping.left.jsonPath»«ENDIF» => «IF mapping.right.type.equals("input")»«mapping.right.name»«ELSE»«mapping.right.jsonPath»«ENDIF» («FOR Similarity sim: mapping.vector.similarities SEPARATOR ', ' »«sim.name»=«sim.sigma»«ENDFOR»)''');
			
		}
		
		
		val nf = NumberFormat.getNumberInstance(Locale.US);
        val f = nf as DecimalFormat;
        f.applyPattern(".###");
		
		var i=1;
		val latextable = 
		'''
		\begin{table}
			\centering
			\footnotesize	
			\begin{tabular}{p{1cm}p{6cm}p{6cm}}
				\rowcolor{grey}
				Rank & 
				$param_1$ &
				$param_2$ &
				$\sigma_1$ &
				$\sigma_2$ &
				$\sigma_3$ &
				$\overline{\sigma}$
				\\
				\hline
				«FOR iomapping: x»
				«IF iomapping.left.jsonPath?.equals("$.ScheduleResource.Schedule.[*].Flight.Departure.ScheduledTimeLocal.DateTime") && iomapping.right.jsonPath?.equals("$.pickupDay")»
				\rowcolor{grey}
				«ENDIF»
				«IF iomapping.left.name.equals("destination") && iomapping.right.jsonPath?.equals("$.pickupLocation")»
				\rowcolor{grey}
				«ENDIF»				
				«i++» & «iomapping.left.name»«IF iomapping.left.jsonPath!==null»\footnote{\textit{«iomapping.left.jsonPath»}}«ENDIF» & «iomapping.right.name»«IF iomapping.right.jsonPath!==null»\footnote{\textit{«iomapping.right.jsonPath»}}«ENDIF» & «FOR Similarity s: iomapping.vector.similarities SEPARATOR ' & '»«f.format(s.sigma)»«ENDFOR» & «f.format(iomapping.score)»\\
				«ENDFOR»
				\hline 
			\end{tabular}
			\caption{Operation ranking for request ``music''}
			\label{tab:MusicResults}
		\end{table}
		'''
		
		System.out.println(latextable);
		
	}
	
	private def wrap(String name){
		
		
		val semanticType = BaasFactory.eINSTANCE.createSemanticType;
		semanticType.uri = "http://schema.org/"+name;
		
		val resource = model.getResource(semanticType.uri);
		
		if(!model.containsResource(resource)){
			throw new IllegalArgumentException(semanticType.uri);
		}
		
		return semanticType;
		
	}
	


}