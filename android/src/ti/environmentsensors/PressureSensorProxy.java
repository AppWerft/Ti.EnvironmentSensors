/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2017 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.environmentsensors;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiC;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

// This proxy can be created by calling Environmentsensors.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = EnvironmentsensorsModule.class)
public class PressureSensorProxy extends KrollProxy implements SensorEventListener {
	// Standard Debugging variables
	private static final String LCAT = "TiPressure";
	private static final boolean DBG = TiConfig.LOGD;

	// Constructor
	public PressureSensorProxy() {
		super();
	}

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options) {
		super.handleCreationDict(options);

		if (options.containsKey("message")) {
			Log.d(LCAT, "example created with message: " + options.get("message"));
		}
	}


	@Override
	public final void onAccuracyChanged(Sensor sensor, int accuracy) {
		// Do something here if sensor accuracy changes.
	}

	@Override
	public final void onSensorChanged(SensorEvent event) {
		KrollFunction cb = (KrollFunction) getProperty("onChanged");
		KrollDict res = new KrollDict();
		res.put("millibarsOfPressure", event.values[0]);
		if (hasProperty("onChanged")) {
			cb.callAsync(getKrollObject(), res);
		}
		if (hasListeners("changed"))
			fireEvent("changed", res);
		// Do something with this sensor data.
	}
	// Methods
	@Kroll.method
	public void printMessage(String message) {
		Log.d(LCAT, "printing message: " + message);
	}

	@Kroll.getProperty
	@Kroll.method
	public String getMessage() {
		return "Hello World from my module";
	}

	@Kroll.setProperty
	@Kroll.method
	public void setMessage(String message) {
		Log.d(LCAT, "Tried setting module message to: " + message);
	}
}
