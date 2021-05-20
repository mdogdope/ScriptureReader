package com.github.mdogdope.scripturereader;

import java.util.Arrays;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.en.us.CMULexicon;
import com.sun.speech.freetts.lexicon.Lexicon;

public class Reader {
	private Voice voice = null;

	public Reader() {
		
		float rate = 150;
		float pitch = 150;
		float volume = 1;
		
		Lexicon custom = new CMULexicon();
		
		System.out.println(custom);
		
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		this.voice = VoiceManager.getInstance().getVoice("kevin16");
		if (this.voice != null) {
			this.voice.allocate();
		}
		this.voice.setRate(rate);
		this.voice.setPitch(pitch);
		this.voice.setVolume(volume);
		
		
		System.out.println(Arrays.toString(this.voice.getLexicon().getPhones("Nephi", null)));
		this.voice.speak("Nephi");
		
	}
	
	public void setRate(Integer rate) {
		this.voice.setRate(rate);
	}
	
	public void setPitch(Float pitch) {
		this.voice.setPitch(pitch);
	}
	
	public void setVolume(Float volume) {
		this.voice.setVolume(volume);
	}
	
	public void read(String text) {
		this.voice.speak(text);
	}
}
