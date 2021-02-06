package dr.manhattan.external.scripts.mchopper;

import dr.manhattan.external.api.MScript;
import dr.manhattan.external.api.interact.MInteract;
import dr.manhattan.external.api.objects.MObjects;
import dr.manhattan.external.api.player.MInventory;
import dr.manhattan.external.api.player.MPlayer;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.plugins.PluginType;
import org.pf4j.Extension;

import javax.inject.Inject;

@Extension
@PluginDescriptor(
	name = "MChopper",
	enabledByDefault = false,
	description = "Cut all the wood",
	tags = {"OpenOSRS", "ProjectM", "Woodcutting", "Automation"},
	type = PluginType.SKILLING
)
public class MChopper extends MScript
{
	@Inject
	private Client client;

	final String[] NAMES = {"Tree"};
	final String[] ACTIONS = {"Chop down"};
	final String[] AXES = {"Bronze axe", "Iron axe"};

	@Override
	public int loop() {
		if(MPlayer.isIdle()){
			if(!MInventory.isFull()){
				log.info("Chop trees");
				chopTrees();
			}
			else{
				log.info("Drop trees");
				dropTrees();
			}
		}
		return 1000;
	}
	private void dropTrees(){
		MInventory.dropAllExcept(AXES);
	}

	private void chopTrees(){
		GameObject tree = new MObjects()
				.hasName(NAMES)
				.hasAction(ACTIONS)
				.isWithinDistance(MPlayer.location(), 20)
				.result(client)
				.nearestTo(MPlayer.get());
		if(tree != null){
			MInteract.GameObject(tree, ACTIONS);
		}
		else log.info("Tree is null :(");
	}
}