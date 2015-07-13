package com.hohmangaming.starcraftmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import buildcraft.core.fluids.BCFluid;
import buildcraft.core.proxy.CoreProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import elliott.starcraftmod.block.BlockCreep;
import elliott.starcraftmod.block.BlockHatchery;
import elliott.starcraftmod.block.BlockMineral;
import elliott.starcraftmod.block.BlockRefinery;
import elliott.starcraftmod.block.BlockRichMineral;
import elliott.starcraftmod.block.BlockStarcraftModFluid;
import elliott.starcraftmod.entity.EntityZergling;
import elliott.starcraftmod.schematic.Schematic;
import elliott.starcraftmod.units.UnitBanshee;
import elliott.starcraftmod.worldgen.BiomeGenVespeneDesert;
import elliott.starcraftmod.worldgen.BiomeGenVespeneOcean;
import elliott.starcraftmod.worldgen.StarcraftModBiomeInitializer;
import elliott.starcraftmod.worldgen.StarcraftWorldGenerator;
import elliott.starcraftmod.worldgen.VespenePopulate;

@Mod(modid="StarcraftMod", name="StarcraftMod", version="0.0.9")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class StarcraftMod {

		public static boolean debugMode = true;
		public static String ASSET_PREFIX = "starcraftmod:";

        // The instance of your mod that Forge uses.
        @Instance("StarcraftMod")
        public static StarcraftMod instance;
       
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="elliott.starcraftmod.ClientProxy", serverSide="elliott.starcraftmod.CommonProxy")
        public static CommonProxy proxy;
       
        /* 
         * BLOCKS - our custom blocks
         */
        public static Block blockMineral = new BlockMineral();
        public static Block blockRichMineral = new BlockRichMineral();
        public static Block blockCreep = new BlockCreep();
        public static Block blockHatchery = new BlockHatchery();
    	public static Block blockVespene;
    	public static Block blockRefinery = new BlockRefinery();

    	public static Block unitBanshee = new UnitBanshee();
    	
        /* 
         * ITEMS - our custom items
         */
        public static Item itemMineral = (new Item(Ids.ITEMID_MINERAL))
        	.setUnlocalizedName("mineral")
        	.setCreativeTab(CreativeTabs.tabMaterials)
        	.setTextureName("starcraftmod:mineral");
        
        public static Item itemRichMineral = (new Item(Ids.ITEMID_RICH_MINERAL))
	    	.setUnlocalizedName("richMineral")
	    	.setCreativeTab(CreativeTabs.tabMaterials)
	    	.setTextureName("starcraftmod:richMineral");
        
        public static Item itemRedstoneCircuit = (new Item(Ids.ITEMID_REDSTONE_CIRCUIT))
	    	.setUnlocalizedName("redstoneCircuit")
	    	.setCreativeTab(CreativeTabs.tabRedstone)
	    	.setTextureName("starcraftmod:redstoneCircuit");
        
        public static Item itemBigRedstoneCircuit = (new Item(Ids.ITEMID_BIG_REDSTONE_CIRCUIT))
	        .setUnlocalizedName("redstoneCircuitBig")
	    	.setCreativeTab(CreativeTabs.tabRedstone)
	    	.setTextureName("starcraftmod:redstoneCircuitBig");
        
        public static Item itemHugeRedstoneCircuit = (new Item(Ids.ITEMID_HUGE_REDSTONE_CIRCUIT))
	    	.setUnlocalizedName("redstoneCircuitHuge")
	    	.setCreativeTab(CreativeTabs.tabRedstone)
	    	.setTextureName("starcraftmod:redstoneCircuitHuge");
        
        public static StarcraftWorldGenerator eventmanager = new StarcraftWorldGenerator();

        /* 
         * BIOMES
         */
    	public static BiomeGenVespeneDesert biomeVespeneDesert;
    	public static BiomeGenVespeneOcean biomeVespeneOcean;
        
        /*
         * SCHEMATICS for structures
         */
        public static Schematic schematicHatchery = new Schematic("/assets/starcraftmod/schematics/hatchery.schematic");
        public static Schematic schematicXelnagaTemple = new Schematic("/assets/starcraftmod/schematics/xelnagaTemple.schematic");
        
        /*
         * FLUIDS
         */
    	private static Fluid buildcraftFluidVespene; // intermediate version of fluid
    	public static Fluid fluidVespene;

    	/*
    	 * ENTITIES
    	 */
    	private static int startEntityId = 300; 
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }

        @EventHandler
        public void load(FMLInitializationEvent event) {
        	
	    	GameRegistry.registerBlock(blockMineral, "blockMineral");
	    	GameRegistry.registerBlock(blockRichMineral, "blockRichMineral");
	    	GameRegistry.registerBlock(blockCreep, "blockCreep");
	    	GameRegistry.registerBlock(blockHatchery, "blockHatchery");
	    	GameRegistry.registerBlock(blockRefinery, "blockRefinery");
	    	GameRegistry.registerBlock(unitBanshee, "unitBanshee");
	    	
	    	LanguageRegistry.addName(blockMineral, "Mineral");
	    	LanguageRegistry.addName(blockRichMineral, "Rich Mineral");
	    	LanguageRegistry.addName(blockCreep, "Creep");
	    	LanguageRegistry.addName(blockHatchery, "Hatchery");
	    	LanguageRegistry.addName(blockRefinery, "Vespene Refinery");
	    	LanguageRegistry.addName(unitBanshee, "Banshee");
	    	
	    	GameRegistry.registerItem(itemMineral, "itemMineral");
	    	GameRegistry.registerItem(itemRichMineral, "itemRichMineral");
	    	GameRegistry.registerItem(itemRedstoneCircuit, "itemRedstoneCircuit");
	    	GameRegistry.registerItem(itemBigRedstoneCircuit, "itemBigRedstoneCircuit");
	    	GameRegistry.registerItem(itemHugeRedstoneCircuit, "itemHugeRedstoneCircuit");

	    	LanguageRegistry.addName(itemMineral, "Starcraft Mineral");
	    	LanguageRegistry.addName(itemRichMineral, "Starcraft Rich Mineral");
	    	LanguageRegistry.addName(itemRedstoneCircuit, "Redstone Circuit");
	    	LanguageRegistry.addName(itemBigRedstoneCircuit, "Big Redstone Circuit");
	    	LanguageRegistry.addName(itemHugeRedstoneCircuit, "Huge Redstone Circuit");

//	    	GameRegistry.addBiome(biomeGenInfested);
//	    	GameRegistry.removeBiome(BiomeGenBase.plains);	    	
//	    	GameRegistry.removeBiome(BiomeGenBase.desert);
	    	GameRegistry.removeBiome(BiomeGenBase.beach);
	    	GameRegistry.removeBiome(BiomeGenBase.desertHills);
	    	GameRegistry.removeBiome(BiomeGenBase.extremeHills);
	    	GameRegistry.removeBiome(BiomeGenBase.extremeHillsEdge);
	    	GameRegistry.removeBiome(BiomeGenBase.forest);
	    	GameRegistry.removeBiome(BiomeGenBase.forestHills);
	    	GameRegistry.removeBiome(BiomeGenBase.frozenOcean);
	    	GameRegistry.removeBiome(BiomeGenBase.frozenRiver);
	    	GameRegistry.removeBiome(BiomeGenBase.jungle);
	    	GameRegistry.removeBiome(BiomeGenBase.jungleHills);
	    	GameRegistry.removeBiome(BiomeGenBase.ocean);
	    	GameRegistry.removeBiome(BiomeGenBase.taiga);
	    	GameRegistry.removeBiome(BiomeGenBase.taigaHills);
	    	
	      	// add a recipe for redstone circuit
        	//  S  r  S
        	//  r  I  r
        	//  S  r  S
        	GameRegistry.addRecipe(
        			new ItemStack(itemRedstoneCircuit), 
        			" r ", 
        			"rir", 
        			" r ",
        	        'r', new ItemStack(Item.redstone), 
        	        'i', new ItemStack(Item.ingotIron));

        	GameRegistry.addRecipe(
        			new ItemStack(itemBigRedstoneCircuit), 
        			"   ", 
        			" rr", 
        			" rr",
        	        'r', new ItemStack(itemRedstoneCircuit)); 
        	        
           	GameRegistry.addRecipe(
        			new ItemStack(itemHugeRedstoneCircuit), 
        			"   ", 
        			" rr", 
        			" rr",
        	        'r', new ItemStack(itemBigRedstoneCircuit)); 
        	        
	    	
            GameRegistry.registerWorldGenerator(eventmanager);

            /*
             * INIT FLUIDS
             */
    		buildcraftFluidVespene = new BCFluid("vespene").setDensity(800).setViscosity(1500);
    		FluidRegistry.registerFluid(buildcraftFluidVespene);
    		fluidVespene = FluidRegistry.getFluid("vespene");

			blockVespene = new BlockStarcraftModFluid(Ids.BLOCKID_VESPENE, fluidVespene, Material.water).setFlammable(false).setFlammability(0);
			blockVespene.setUnlocalizedName("blockVespene");
			CoreProxy.proxy.addName(blockVespene, "Vespene");
			CoreProxy.proxy.registerBlock(blockVespene);
			fluidVespene.setBlockID(blockVespene);
            
			// TODO - have not setup Vespene to spring (geyser?)
//			if (blockOil != null) {
//				Property oilSpringsProp = BuildCraftCore.mainConfiguration.get(Configuration.CATEGORY_GENERAL, "oilSprings", true);
//				spawnOilSprings = oilSpringsProp.getBoolean(true);
//				BlockSpring.EnumSpring.OIL.canGen = spawnOilSprings;
//				BlockSpring.EnumSpring.OIL.liquidBlock = blockOil;
//			}

			
			/*
			 * BIOME gen
			 */
			biomeVespeneDesert = BiomeGenVespeneDesert.makeBiome(Ids.BIOME_VESPENE_DESERT);
			biomeVespeneOcean = BiomeGenVespeneOcean.makeBiome(Ids.BIOME_VESPENE_OCEAN);

			/*
			 * ENTITIES
			 */
			EntityRegistry.registerModEntity(EntityZergling.class, "Zergling", 1, this, 40, 3, true);
//			EntityRegistry.addSpawn(EntityZergling.class, weightedProb, min, max, typeOfCreature, biomes)
			registerEntityEgg(EntityZergling.class, 0x000000, 0xFFFFFF);
		    LanguageRegistry.instance().addStringLocalization("entity.Zergling.name", "en_US","Zergling");//set a more readable name for the entity in given language

	       	proxy.registerRenderers();

        }
       
    	@ForgeSubscribe
    	@SideOnly(Side.CLIENT)
    	public void textureHook(TextureStitchEvent.Post event) {
    		if (event.map.textureType == 0) {
    			buildcraftFluidVespene.setIcons(blockVespene.getBlockTextureFromSide(1), blockVespene.getBlockTextureFromSide(2));
    		}
    	}

    	@EventHandler
    	public void postInit(FMLPostInitializationEvent evt) {
   			MinecraftForge.EVENT_BUS.register(VespenePopulate.INSTANCE);
   			MinecraftForge.TERRAIN_GEN_BUS.register(new StarcraftModBiomeInitializer());
    	}

    	public static int getUniqueEntityId() {
    		do {
    			startEntityId++;
    		} while(EntityList.getStringFromID(startEntityId) != null);
    		
    		return startEntityId;
    	}
    	
    	public static void registerEntityEgg(Class <? extends Entity> entity, int primaryColor, int secondaryColor) {
    		int id = getUniqueEntityId();
    		EntityList.IDtoClassMapping.put(id, entity);
    		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    	}
    	
    	
}



