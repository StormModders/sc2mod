package com.hohmangaming.starcraftmod;

import com.hohmangaming.starcraftmod.block.BlockCreep;
import com.hohmangaming.starcraftmod.block.BlockHatchery;
import com.hohmangaming.starcraftmod.block.BlockMineral;
import com.hohmangaming.starcraftmod.block.BlockRefinery;
import com.hohmangaming.starcraftmod.block.BlockRichMineral;
import com.hohmangaming.starcraftmod.block.BlockVespene;
import com.hohmangaming.starcraftmod.block.FluidVespene;
import com.hohmangaming.starcraftmod.block.MaterialVespene;
import com.hohmangaming.starcraftmod.schematic.Schematic;
import com.hohmangaming.starcraftmod.worldgen.StarcraftWorldGenerator;
import com.hohmangaming.starcraftmod.worldgen.VespenePopulate;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityList.EntityEggInfo;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = StarcraftMod.MODID, version = StarcraftMod.VERSION)
public class StarcraftMod {

	
    	public static final String MODID = "StarcraftMod";
    	public static final String VERSION = "0.0.9";
    
		public static boolean debugMode = true;
		public static String ASSET_PREFIX = "starcraftmod:";

        // The instance of your mod that Forge uses.
        @Instance("StarcraftMod")
        public static StarcraftMod instance;
       
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="com.hohmangaming.starcraftmod.ClientProxy", serverSide="com.hohmangaming.starcraftmod.CommonProxy")
        public static CommonProxy proxy;
       
    	/*
    	 * MATERIALS
    	 */
    	public static Material materialVespene;
    	
        /* 
         * ITEMS - our custom items
         */
        public static Item itemMineral = (new Item())
        	.setUnlocalizedName("itemMineral")
        	.setCreativeTab(CreativeTabs.tabMaterials)
        	.setTextureName("starcraftmod:mineral");
        
        public static Item itemRichMineral = (new Item())
	    	.setUnlocalizedName("itemRichMineral")
	    	.setCreativeTab(CreativeTabs.tabMaterials)
	    	.setTextureName("starcraftmod:richMineral");
        
        public static Item itemRedstoneCircuit = (new Item())
	    	.setUnlocalizedName("itemRedstoneCircuit")
	    	.setCreativeTab(CreativeTabs.tabRedstone)
	    	.setTextureName("starcraftmod:redstoneCircuit");
        
        public static Item itemBigRedstoneCircuit = (new Item())
	        .setUnlocalizedName("itemRedstoneCircuitBig")
	    	.setCreativeTab(CreativeTabs.tabRedstone)
	    	.setTextureName("starcraftmod:redstoneCircuitBig");
        
        public static Item itemHugeRedstoneCircuit = (new Item())
	    	.setUnlocalizedName("itemRedstoneCircuitHuge")
	    	.setCreativeTab(CreativeTabs.tabRedstone)
	    	.setTextureName("starcraftmod:redstoneCircuitHuge");
        
        public static StarcraftWorldGenerator starcraftWorldGenerator = new StarcraftWorldGenerator();
        
        /*
         * SCHEMATICS for structures
         */
        public static Schematic schematicHatchery = new Schematic("/assets/starcraftmod/schematics/hatchery.schematic");
        public static Schematic schematicXelnagaTemple = new Schematic("/assets/starcraftmod/schematics/xelnagaTemple.schematic");
        
        /*
         * FLUIDS
         */
    	public static Fluid fluidVespene;

        /* 
         * BLOCKS - our custom blocks
         */
        public static Block blockMineral;
        public static Block blockRichMineral;
        public static Block blockCreep;
        public static Block blockHatchery;
    	public static Block blockVespene;
    	public static Block blockRefinery;

    	/*
    	 * ENTITIES
    	 */
    	private static int startEntityId = 300; 
        
        @EventHandler
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }

        @EventHandler
        public void init(FMLInitializationEvent event) {

        	// Vespene
        	materialVespene = new MaterialVespene();
	    	fluidVespene = new FluidVespene();
	    	FluidRegistry.registerFluid(fluidVespene);
        	blockVespene = new BlockVespene();
	    	GameRegistry.registerBlock(blockVespene, "blockVespene");

        	// All other blocks
            blockMineral = new BlockMineral();
            blockRichMineral = new BlockRichMineral();
            blockCreep = new BlockCreep();
            blockHatchery = new BlockHatchery();
        	blockRefinery = new BlockRefinery();

        	
	    	GameRegistry.registerBlock(blockMineral, "blockMineral");
	    	GameRegistry.registerBlock(blockRichMineral, "blockRichMineral");
	    	GameRegistry.registerBlock(blockCreep, "blockCreep");
	    	GameRegistry.registerBlock(blockHatchery, "blockHatchery");
	    	GameRegistry.registerBlock(blockRefinery, "blockRefinery");
//	    	GameRegistry.registerBlock(unitBanshee, "unitBanshee");
	    	
	    	
	    	GameRegistry.registerItem(itemMineral, "itemMineral");
	    	GameRegistry.registerItem(itemRichMineral, "itemRichMineral");
	    	GameRegistry.registerItem(itemRedstoneCircuit, "itemRedstoneCircuit");
	    	GameRegistry.registerItem(itemBigRedstoneCircuit, "itemBigRedstoneCircuit");
	    	GameRegistry.registerItem(itemHugeRedstoneCircuit, "itemHugeRedstoneCircuit");

	      	// add a recipe for redstone circuit
        	//  S  r  S
        	//  r  I  r
        	//  S  r  S
        	GameRegistry.addRecipe(
        			new ItemStack(itemRedstoneCircuit), 
        			" r ", 
        			"rir", 
        			" r ",
        	        'r', new ItemStack(Items.redstone), 
        	        'i', new ItemStack(Items.iron_ingot));

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
        	        
	    	
            GameRegistry.registerWorldGenerator(starcraftWorldGenerator, 0);

            /*
             * INIT FLUIDS
             */
            // BOBHO TODO - deal with fluids
//    		buildcraftFluidVespene = new BCFluid("vespene").setDensity(800).setViscosity(1500);
//    		FluidRegistry.registerFluid(buildcraftFluidVespene);
//    		fluidVespene = FluidRegistry.getFluid("vespene");
//
//			blockVespene = new BlockStarcraftModFluid(Ids.BLOCKID_VESPENE, fluidVespene, Material.water).setFlammable(false).setFlammability(0);
//			blockVespene.setUnlocalizedName("blockVespene");
//			CoreProxy.proxy.addName(blockVespene, "Vespene");
//			CoreProxy.proxy.registerBlock(blockVespene);
//			fluidVespene.setBlockID(blockVespene);
//            
			// TODO - have not setup Vespene to spring (geyser?)
//			if (blockOil != null) {
//				Property oilSpringsProp = BuildCraftCore.mainConfiguration.get(Configuration.CATEGORY_GENERAL, "oilSprings", true);
//				spawnOilSprings = oilSpringsProp.getBoolean(true);
//				BlockSpring.EnumSpring.OIL.canGen = spawnOilSprings;
//				BlockSpring.EnumSpring.OIL.liquidBlock = blockOil;
//			}

			
			/*
			 * ENTITIES
			 */
            // BOBHO TODO - deal with zergling
//			EntityRegistry.registerModEntity(EntityZergling.class, "Zergling", 1, this, 40, 3, true);
//			EntityRegistry.addSpawn(EntityZergling.class, weightedProb, min, max, typeOfCreature, biomes)
//			registerEntityEgg(EntityZergling.class, 0x000000, 0xFFFFFF);
//		    LanguageRegistry.instance().addStringLocalization("entity.Zergling.name", "en_US","Zergling");//set a more readable name for the entity in given language

	       	proxy.registerRenderers();

        }
       
    	@SubscribeEvent
    	@SideOnly(Side.CLIENT)
    	public void textureHook(TextureStitchEvent.Post event) {
    		if (event.map.getTextureType() == 0) {
    			fluidVespene.setIcons(blockVespene.getBlockTextureFromSide(1), blockVespene.getBlockTextureFromSide(2));
    		}
    	}

    	@EventHandler
    	public void postInit(FMLPostInitializationEvent evt) {
   			MinecraftForge.EVENT_BUS.register(VespenePopulate.INSTANCE);
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



