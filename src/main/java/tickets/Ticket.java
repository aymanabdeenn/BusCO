package tickets;

import models.fareConfig;

public interface Ticket {
	public void calcPrice(fareConfig fare_config);
	public String getType();
	public String getCategory();
	public String getUser();
	public String getPurchaseDate();
	public float getPrice();
	public int getTripNumber();
}
