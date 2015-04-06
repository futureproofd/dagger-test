package to.marcus.simple_dagger_test.network;

import android.net.Uri;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

import to.marcus.simple_dagger_test.model.Image;

/**
 * Created by marcus on 4/6/2015.
 * Flickr API
 */
public class EndPoint {
    public static final String TAG = "EndPoint";
    private static final String ENDPOINT = "https://api.flickr.com/services/rest/";
    private static final String API_KEY = "4b37ee018d17b1aa7cd793ede2ea7ee7";
    private static final String GET_RECENT = "flickr.photos.getRecent";
    private static final String PARAM_EXTRAS = "extras";
    private static final String EXTRA_SMALL_URL = "urls_s";
    private static final String XML_PHOTO = "photo";

    /*
    * Get URL byte contents from URI and parse items into ArrayList
    *
     */
    public ArrayList<Image> getXMLContent(WebConnection httpConnection) throws IOException{
        ArrayList<Image> images = new ArrayList<Image>();

        try{
            String url = Uri.parse(ENDPOINT).buildUpon()
                    .appendQueryParameter("method", GET_RECENT)
                    .appendQueryParameter("api_key", API_KEY)
                    .appendQueryParameter(PARAM_EXTRAS, EXTRA_SMALL_URL)
                    .build().toString();
            String xmlString = httpConnection.getUrl(url);
            Log.i(TAG, "Received XML: " + xmlString);
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(new StringReader(xmlString));
            parseItems(images, parser);
        }catch (IOException ioe){
            Log.e(TAG, "Failed to fetch items", ioe);
        }catch (XmlPullParserException xppe){
            Log.e(TAG, "Failed to parse items", xppe);
        }
        return images;
    }

    /**
     * parses xml String contents of getXMLContent into ArrayList
     */
    public void parseItems(ArrayList<Image> images, XmlPullParser parser)
            throws XmlPullParserException, IOException{
        int eventType = parser.next();

        while (eventType != XmlPullParser.END_DOCUMENT){
            if(eventType == XmlPullParser.START_TAG && XML_PHOTO.equals(parser.getName())){
                String id = parser.getAttributeValue(null, "id");
                String caption = parser.getAttributeValue(null, "title");
                String smallUrl = parser.getAttributeValue(null, EXTRA_SMALL_URL);

                Image image = new Image();
                image.setId(id);
                image.setCaption(caption);
                image.setUrl(smallUrl);
                images.add(image);
            }
            eventType = parser.next();
        }
    }

}
