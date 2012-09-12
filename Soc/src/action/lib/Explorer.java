package action.lib;

import direction.lib.WindRose;

import world.lib.Cell;
import agents.api.Agent;

public class Explorer extends AgentAction {

	public Explorer(Agent a){
		this.agent = a;
		this.name = "Explorer";
	}
	
	public boolean act() {
		this.agent.lastaction = this.getName();
		int portee = this.agent.portee;
		Cell ici = this.agent.getCell();
		int i = 0 ;
		Cell north = ici.getMapDirections().get(WindRose.North);
		Cell south = ici.getMapDirections().get(WindRose.South);
		Cell East = ici.getMapDirections().get(WindRose.East);
		Cell NorthEast = ici.getMapDirections().get(WindRose.NorthEast );
		Cell NorthWest = ici.getMapDirections().get(WindRose.NorthWest);
		Cell SouthEast = ici.getMapDirections().get(WindRose.SouthEast);
		Cell SouthWest = ici.getMapDirections().get(WindRose.SouthWest);
		Cell West = ici.getMapDirections().get(WindRose.West);
		while (i<portee){
			i++;
			if (north.contientNourriture()){
				if(!this.agent.nation.foodList.contains(north)){
						this.agent.nation.foodList.add(north);
						//System.out.println("bouffe ici"+north);
				}
			}
			if (south.contientNourriture()){
				if(!this.agent.nation.foodList.contains(south)){
					this.agent.nation.foodList.add(south);
					//System.out.println("bouffe ici"+south);
				}
			}
			if (East.contientNourriture()){
				if(!this.agent.nation.foodList.contains(East)){
					this.agent.nation.foodList.add(East);
					//System.out.println("bouffe ici"+East);
				}
			}
			if (NorthEast.contientNourriture()){
				if(!this.agent.nation.foodList.contains(NorthEast)){
					this.agent.nation.foodList.add(NorthEast);
					//System.out.println("bouffe ici"+NorthEast);
				}
			}
			if (NorthWest.contientNourriture()){
				if(!this.agent.nation.foodList.contains(NorthWest)){
					this.agent.nation.foodList.add(NorthWest);
					//System.out.println("bouffe ici"+NorthWest);
				}
			}
			if (SouthEast.contientNourriture()){
				if(!this.agent.nation.foodList.contains(SouthEast)){
					this.agent.nation.foodList.add(SouthEast);
					//System.out.println("bouffe ici"+SouthEast);
				}
			}
			if (SouthWest.contientNourriture()){
				if(!this.agent.nation.foodList.contains(SouthWest)){
					this.agent.nation.foodList.add(SouthWest);
					//System.out.println("bouffe ici"+SouthWest);
				}
			}
			if (West.contientNourriture()){
				if(!this.agent.nation.foodList.contains(West)){
					this.agent.nation.foodList.add(West);
					//System.out.println("bouffe ici"+West);
				}
			}
			north = north.getMapDirections().get(WindRose.North);
			south = south.getMapDirections().get(WindRose.South);
			East = East.getMapDirections().get(WindRose.East);
			NorthEast = NorthEast.getMapDirections().get(WindRose.NorthEast );
			NorthWest = NorthWest.getMapDirections().get(WindRose.NorthWest);
			SouthEast = SouthEast.getMapDirections().get(WindRose.SouthEast);
			SouthWest = SouthWest.getMapDirections().get(WindRose.SouthWest);
			West = West.getMapDirections().get(WindRose.West);			
		}
		return true;
	}

	public int energyCost() {
		return 1;
	}

	public String getName() {
		return "Explorer";
	}

	public boolean isPossible() {
		if (this.agent.getCell().contientNourriture())//est déjà sur de la bouffe... non sens de rechercher.
			return false;
		return true;
	}

}
