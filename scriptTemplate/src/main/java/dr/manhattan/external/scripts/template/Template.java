package dr.manhattan.external.scripts.template;

import dr.manhattan.external.api.MScript;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import org.pf4j.Extension;

@Extension
@PluginDescriptor(
	name = "Script Template",
	enabledByDefault = false,
	description = "Just a template",
	tags = {"OpenOSRS", "ProjectM", "Template"},
	type = PluginType.UNCATEGORIZED
)
public class Template extends MScript
{

	@Override
	public int loop() {
		return 1000;
	}
}