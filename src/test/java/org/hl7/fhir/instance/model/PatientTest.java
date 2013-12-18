package org.hl7.fhir.instance.model;

import java.io.ByteArrayOutputStream;

import org.hl7.fhir.instance.formats.JsonComposer;
import org.hl7.fhir.instance.formats.XmlComposer;
import org.junit.Before;
import org.junit.Test;

public class PatientTest {

	private Patient patient;
	private JsonComposer jsonComposer;
	private XmlComposer xmlComposer;
	
	@Before
	public void setUp(){
		patient = new Patient().setActiveSimple(true);
		HumanName name = patient.addName();
		name.addGivenSimple("Jan");
		name.addGivenSimple("J.");
		name.addGivenSimple("F.");
		name.addFamilySimple("Fictief");
		jsonComposer = new JsonComposer();
		xmlComposer = new XmlComposer();
	}
	
	@Test
	public void testJson() throws Exception {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		jsonComposer.compose(bao, patient, true);
		String json = bao.toString();
		System.out.println(json);
	}
	
	@Test
	public void testXml() throws Exception {
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		xmlComposer.compose(bao, patient, true);
		System.out.println(bao.toString());
	}

}
