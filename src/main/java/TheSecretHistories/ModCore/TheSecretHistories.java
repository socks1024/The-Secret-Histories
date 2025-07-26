package TheSecretHistories.ModCore;
import TheSecretHistories.Content.Cards.Template.TemplateMultiLevelOptionCard;
import TheSecretHistories.Content.Cards.Template.TemplateOptionCard;
import TheSecretHistories.Content.Characters.TheSeeker;
import TheSecretHistories.Content.Events.BookShop;
import TheSecretHistories.Data.DynamicVariable.PrincipleVariant;
import TheSecretHistories.Utils.DebugUtils;
import TheSecretHistories.Utils.StringUtils;
import basemod.AutoAdd;
import basemod.BaseMod;
import basemod.abstracts.CustomRelic;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.google.gson.Gson;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.*;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

import java.nio.charset.StandardCharsets;

import static TheSecretHistories.Content.Characters.TheSeeker.PlayerColorEnum.THE_SEEKER;
import static com.megacrit.cardcrawl.core.Settings.language;


@SpireInitializer
public class TheSecretHistories implements
        PostInitializeSubscriber,
        EditCardsSubscriber,
        EditStringsSubscriber,
        EditCharactersSubscriber,
        EditRelicsSubscriber,
        EditKeywordsSubscriber{

    public static final Color CULT_BLUE = new Color(26.0f/255.0f,74.0f/255.0f,79.0f/255.f,1.0f);
    private static final String THE_SEEKER_BUTTON = "TheSecretHistories/img/character/Character_Button.png";
    private static final String THE_SEEKER_PORTRAIT = "TheSecretHistories/img/character/backgroundperson.png";
    private static final String BG_ATTACK_512 = "TheSecretHistories/img/character/cardbackground/AttackBackground_s.png";
    private static final String BG_POWER_512 = "TheSecretHistories/img/character/cardbackground/PowerBackground_s.png";
    private static final String BG_SKILL_512 = "TheSecretHistories/img/character/cardbackground/SkillBackground_s.png";
    private static final String SMALL_ORB = "TheSecretHistories/img/character/char/splendid_small_orb.png";
    private static final String BG_ATTACK_1024 = "TheSecretHistories/img/character/cardbackground/AttackBackground.png";
    private static final String BG_POWER_1024 = "TheSecretHistories/img/character/cardbackground/PowerBackground.png";
    private static final String BG_SKILL_1024 = "TheSecretHistories/img/character/cardbackground/SkillBackground.png";
    private static final String BIG_ORB = "TheSecretHistories/img/character/char/splendid_card_orb.png";
    private static final String ENERGY_ORB = "TheSecretHistories/img/character/char/splendid_cost_orb.png";

    public TheSecretHistories(){
        BaseMod.subscribe(this);
        BaseMod.addColor(TheSeeker.PlayerColorEnum.CULT_BLUE,CULT_BLUE,CULT_BLUE,CULT_BLUE,CULT_BLUE,CULT_BLUE,CULT_BLUE,CULT_BLUE,BG_ATTACK_512,BG_SKILL_512,BG_POWER_512,ENERGY_ORB,BG_ATTACK_1024,BG_SKILL_1024,BG_POWER_1024,BIG_ORB,SMALL_ORB);
    }

    // 事件的注册写在这里
    @Override
    public void receivePostInitialize() {
        // AutoAdd
        // BaseMod.addEvent(BookShop.ID, BookShop.class);
    }

    public static void initialize()
    {
        new TheSecretHistories();
    }

    public String modID = "TheSecretHistories";
    public String packageNameCard = "TheSecretHistories.Content.Cards";
    public String packageNameRelic = "TheSecretHistories.Content.Relics";
    public String packageNameEvent = "TheSecretHistories.Content.Events";

    @Override
    public void receiveEditCards() {
        BaseMod.addDynamicVariable(new PrincipleVariant());

        new AutoAdd(modID)
                .packageFilter(packageNameCard)
                .notPackageFilter("TheSecretHistories.Content.Cards.Mansus.OptionCards")
                .notPackageFilter("TheSecretHistories.Content.Cards.Spirits.Options")
                .setDefaultSeen(true)
                .cards();
    }

    @Override
    public void receiveEditStrings() {
        String lang;
        if (language == Settings.GameLanguage.ZHS) {
            lang = "ZHS";
        } else {
            lang = "ENG";
        }

        DebugUtils.Log(language.toString());

        BaseMod.loadCustomStringsFile(CardStrings.class, "TheSecretHistories/Localization/" + lang + "/cards.json");
        BaseMod.loadCustomStringsFile(CharacterStrings.class, "TheSecretHistories/Localization/" + lang + "/characters.json");
        BaseMod.loadCustomStringsFile(RelicStrings.class, "TheSecretHistories/Localization/" + lang + "/relics.json");
        BaseMod.loadCustomStringsFile(PowerStrings.class, "TheSecretHistories/Localization/" + lang + "/powers.json");
        BaseMod.loadCustomStringsFile(EventStrings.class, StringUtils.MakeLocalizationPath("events.json"));
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new TheSeeker(CardCrawlGame.playerName), THE_SEEKER_BUTTON, THE_SEEKER_PORTRAIT, THE_SEEKER);
    }

    @Override
    public void receiveEditRelics() {
        new AutoAdd(modID)
            .packageFilter(packageNameRelic)
            .any(CustomRelic.class, (info, relic) -> {
                BaseMod.addRelicToCustomPool(relic, TheSeeker.PlayerColorEnum.CULT_BLUE);
                if (info.seen) {
                    UnlockTracker.markRelicAsSeen(relic.relicId);
                }
            });
    }

    @Override
    public void receiveEditKeywords() {
        Gson gson = new Gson();
        String lang = "ENG";
        if (language == Settings.GameLanguage.ZHS) {
            lang = "ZHS";
        }

        String json = Gdx.files.internal("TheSecretHistories/Localization/" + lang + "/keywords.json").readString(String.valueOf(StandardCharsets.UTF_8));
        Keyword[] keywords = gson.fromJson(json, Keyword[].class);
        if (keywords != null) {
            for (Keyword keyword : keywords) {
                BaseMod.addKeyword("tsh", keyword.NAMES[0], keyword.NAMES, keyword.DESCRIPTION);
            }
        }
    }
}
