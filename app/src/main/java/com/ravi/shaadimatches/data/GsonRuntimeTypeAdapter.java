package com.ravi.shaadimatches.data;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class GsonRuntimeTypeAdapter implements JsonDeserializer<ValueRuntime>, JsonSerializer<ValueRuntime>
{
    public ValueRuntime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        int runtime;
        try
        {
            runtime = json.getAsInt();
        }
        catch (NumberFormatException e)
        {
            runtime = 0;
        }
        return new ValueRuntime(runtime);
    }

    public JsonElement serialize(ValueRuntime src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.getValue());
    }
}