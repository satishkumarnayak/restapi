package com.instanceofcake.restconsuming.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.instanceofcake.restconsuming.domain.City;

public class Util {

	public static ImmutableList<City> getMockResponse() {
		InputStream inputStream;
		String json = new String();
		try {
			inputStream = Resources.getResource("static/response.json").openStream();
			json = IOUtils.toString(inputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}

		Type listType = new TypeToken<ArrayList<City>>() {
		}.getType();
		List<City> data = new Gson().fromJson(json, listType);
		return ImmutableList.copyOf(data);
	}
}
