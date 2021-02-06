package dr.manhattan.external.scripts.mchopper;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigTitleSection;
import net.runelite.client.config.Title;

@ConfigGroup("m")
public interface MChopperConfig extends Config
{
	@ConfigTitleSection(
		keyName = "mainTitle",
		name = "MChopper",
		description = "Configure MChopper",
		position = 0
	)
	default Title mainTitle()
	{
		return new Title();
	}

	@ConfigItem(
			keyName = "bankLogs",
			name = "Bank logs?",
			description = "Bank the logs.",
			position = 1,
			titleSection = "mainTitle"
	)
	default boolean bankLogs()
	{
		return true;
	}

}
