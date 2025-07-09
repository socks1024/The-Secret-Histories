package TheSecretHistories.Content.Relics;

import TheSecretHistories.Content.Relics.Template.TemplateCustomRelic;
import TheSecretHistories.Utils.StringUtils;
import basemod.abstracts.CustomRelic;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.RetainCardsAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class TemporaryHeadquarters extends TemplateCustomRelic {

    public static final String ID = StringUtils.MakeID(TemporaryHeadquarters.class.getSimpleName());
    private static final String IMG_NAME = TemporaryHeadquarters.class.getSimpleName();
    private static final RelicTier RELIC_TIER = RelicTier.STARTER;
    private static final LandingSound LANDING_SOUND = LandingSound.FLAT;

    public TemporaryHeadquarters() {
        super(ID, IMG_NAME, RELIC_TIER, LANDING_SOUND);
    }

    private boolean firstTurn = true;

    public void onPlayerEndTurn() {
        if(this.firstTurn){
            if (!AbstractDungeon.player.hand.isEmpty()){
                flash();
                addToTop(new RetainCardsAction(AbstractDungeon.player, 1));
            }

            firstTurn = false;
        }

    }

    public void atPreBattle(){
        this.firstTurn = true;
    }
}