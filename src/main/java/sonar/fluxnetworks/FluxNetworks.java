package sonar.fluxnetworks;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sonar.fluxnetworks.common.util.EnergyUtils;

import javax.annotation.Nonnull;

@Mod(FluxNetworks.MODID)
public class FluxNetworks {

    public static final String MODID = "fluxnetworks";
    public static final String NAME = "Flux Networks";
    public static final String NAME_CPT = "FluxNetworks";

    public static final Logger LOGGER = LogManager.getLogger(NAME_CPT);

    private static boolean sCuriosLoaded;
    private static boolean sModernUILoaded;
    private static boolean sGTCEULoaded;

    public FluxNetworks() {
        sCuriosLoaded = ModList.get().isLoaded("curios");
        sModernUILoaded = ModList.get().isLoaded("modernui");
        sGTCEULoaded = ModList.get().isLoaded("gtceu");

        FluxConfig.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(FluxNetworks::onCommonSetup);
    }

    public static boolean isCuriosLoaded() {
        return sCuriosLoaded;
    }

    public static boolean isModernUILoaded() {
        return sModernUILoaded;
    }
    public static boolean isGTCEULoaded() {
        return sGTCEULoaded;
    }

    @Nonnull
    public static ResourceLocation location(String path) {
        return new ResourceLocation(MODID, path);
    }

    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        EnergyUtils.register();
    }
}
