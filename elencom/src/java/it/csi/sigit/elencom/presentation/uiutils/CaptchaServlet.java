package it.csi.sigit.elencom.presentation.uiutils;

import it.csi.sigit.elencom.util.Constants;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import nl.captcha.noise.CurvedLineNoiseProducer;
import nl.captcha.servlet.CaptchaServletUtil;
import nl.captcha.text.producer.DefaultTextProducer;

public class CaptchaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * dimensione orizzontale dell'immagine
	 */
	private static final int HSIZE = 150;

	/**
	 * dimensione verticale dell'immagine
	 */
	private static final int VSIZE = 40;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Captcha captcha = new Captcha.Builder(HSIZE, VSIZE).addBackground(new GradiatedBackgroundProducer())
				.addNoise(new CurvedLineNoiseProducer(Color.gray, 3))
				.addNoise(new CurvedLineNoiseProducer(new Color(233, 235, 234), 5)).addText(new DefaultTextProducer())
				.build();

		CaptchaServletUtil.writeImage(resp, captcha.getImage());
		req.getSession().setAttribute(Constants.CAPTCHA_SESSION_NAME, captcha);
	}

}
