package com.hohmangaming.starcraftmod.units;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelZergling extends ModelBase
{
  //fields
    ModelRenderer tail2;
    ModelRenderer tail1;
    ModelRenderer body_1;
    ModelRenderer tail6;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer tail5;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body6;
    ModelRenderer body7;
    ModelRenderer head;
    ModelRenderer head2;
    ModelRenderer head1;
    ModelRenderer head3;
    ModelRenderer head4;
    ModelRenderer head5;
    ModelRenderer head6;
    ModelRenderer legsquare2;
    ModelRenderer legsqaure1;
    ModelRenderer legup1;
    ModelRenderer claw1;
    ModelRenderer claw2;
    ModelRenderer claw3;
    ModelRenderer claw4;
    ModelRenderer claw5;
    ModelRenderer claw6;
    ModelRenderer claw7;
    ModelRenderer claw8;
    ModelRenderer legup2;
    ModelRenderer claw9;
    ModelRenderer claw15;
    ModelRenderer body5;
    ModelRenderer claw11;
    ModelRenderer claw16;
    ModelRenderer claw10;
    ModelRenderer claw17;
    ModelRenderer claw18;
    ModelRenderer claw14;
    ModelRenderer claw19;
    ModelRenderer claw13;
    ModelRenderer claw20;
    ModelRenderer claw12;
    ModelRenderer Hind_up_1;
    ModelRenderer Hind_across_1;
    ModelRenderer Hind_foot_1;
    ModelRenderer Hind_leg_1;
    ModelRenderer Hind_up_2;
    ModelRenderer Hind_across_2;
    ModelRenderer Hind_foot_2;
    ModelRenderer Hind_leg_2;
  
  public ModelZergling()
  {
    textureWidth = 256;
    textureHeight = 128;
    
      tail2 = new ModelRenderer(this, 0, 0);
      tail2.addBox(0F, 0F, 0F, 2, 1, 6);
      tail2.setRotationPoint(-1F, 22.5F, -18.3F);
      tail2.setTextureSize(64, 32);
      tail2.mirror = true;
      setRotation(tail2, 0.4304494F, 0F, 0F);
      tail1 = new ModelRenderer(this, 0, 0);
      tail1.addBox(0F, 0F, 0F, 2, 1, 6);
      tail1.setRotationPoint(-1F, 23F, -24F);
      tail1.setTextureSize(64, 32);
      tail1.mirror = true;
      setRotation(tail1, 0.0872665F, 0F, 0F);
      body_1 = new ModelRenderer(this, 0, 0);
      body_1.addBox(-1F, 0F, 0F, 4, 4, 4);
      body_1.setRotationPoint(-1F, 19F, -12.7F);
      body_1.setTextureSize(64, 32);
      body_1.mirror = true;
      setRotation(body_1, 1.041962F, 0F, 0F);
      tail6 = new ModelRenderer(this, 0, 0);
      tail6.addBox(0F, 0F, 0F, 2, 1, 2);
      tail6.setRotationPoint(-1F, 19.4F, -11.43333F);
      tail6.setTextureSize(64, 32);
      tail6.mirror = true;
      setRotation(tail6, -2.186819F, 0F, 0F);
      tail3 = new ModelRenderer(this, 0, 0);
      tail3.addBox(0F, 0F, 0F, 2, 1, 5);
      tail3.setRotationPoint(-1F, 22.6F, -18.3F);
      tail3.setTextureSize(64, 32);
      tail3.mirror = true;
      setRotation(tail3, 0.3520608F, 0F, 0F);
      tail4 = new ModelRenderer(this, 0, 0);
      tail4.addBox(0F, 0F, 0F, 2, 1, 4);
      tail4.setRotationPoint(-1F, 21.5F, -15F);
      tail4.setTextureSize(64, 32);
      tail4.mirror = true;
      setRotation(tail4, 0.8551081F, 0F, 0F);
      tail5 = new ModelRenderer(this, 0, 0);
      tail5.addBox(0F, 0F, 0F, 2, 1, 4);
      tail5.setRotationPoint(-1F, 20F, -10F);
      tail5.setTextureSize(64, 32);
      tail5.mirror = true;
      setRotation(tail5, -2.649536F, 0F, 0F);
      body2 = new ModelRenderer(this, 0, 0);
      body2.addBox(-2F, 0F, 0F, 6, 5, 6);
      body2.setRotationPoint(-1F, 15.6F, -10.7F);
      body2.setTextureSize(64, 32);
      body2.mirror = true;
      setRotation(body2, 0.6813093F, 0F, 0F);
      body3 = new ModelRenderer(this, 0, 0);
      body3.addBox(-2F, 0F, 0F, 6, 6, 5);
      body3.setRotationPoint(-1F, 11.8F, -6F);
      body3.setTextureSize(64, 32);
      body3.mirror = true;
      setRotation(body3, 0F, 0F, 0F);
      body4 = new ModelRenderer(this, 0, 0);
      body4.addBox(-1F, 0F, 0F, 6, 5, 5);
      body4.setRotationPoint(-2F, 11.8F, -1F);
      body4.setTextureSize(64, 32);
      body4.mirror = true;
      setRotation(body4, -0.4886922F, 0F, 0F);
      body6 = new ModelRenderer(this, 0, 0);
      body6.addBox(-1F, -1F, 0F, 6, 3, 7);
      body6.setRotationPoint(-2F, 15.1F, 3.1F);
      body6.setTextureSize(64, 32);
      body6.mirror = true;
      setRotation(body6, -0.8179294F, 0F, 0F);
      body7 = new ModelRenderer(this, 0, 0);
      body7.addBox(-1F, 0F, 0F, 6, 2, 1);
      body7.setRotationPoint(-2F, 13.9F, 3F);
      body7.setTextureSize(64, 32);
      body7.mirror = true;
      setRotation(body7, -0.5585054F, 0F, 0F);
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-1F, 0F, 4F, 4, 4, 5);
      head.setRotationPoint(-1F, 18F, 3F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      head2 = new ModelRenderer(this, 0, 0);
      head2.addBox(0F, 0F, 0F, 1, 4, 6);
      head2.setRotationPoint(-3F, 18F, 6F);
      head2.setTextureSize(64, 32);
      head2.mirror = true;
      setRotation(head2, 0F, 0.1396263F, 0F);
      head1 = new ModelRenderer(this, 0, 0);
      head1.addBox(0F, 0F, 0F, 1, 4, 6);
      head1.setRotationPoint(2F, 18F, 6F);
      head1.setTextureSize(64, 32);
      head1.mirror = true;
      setRotation(head1, 0F, -0.1396263F, 0F);
      head3 = new ModelRenderer(this, 0, 0);
      head3.addBox(0F, 0F, -1F, 1, 1, 4);
      head3.setRotationPoint(-3F, 19F, 9F);
      head3.setTextureSize(64, 32);
      head3.mirror = true;
      setRotation(head3, -0.2876179F, -0.8726646F, 0F);
      head4 = new ModelRenderer(this, 0, 0);
      head4.addBox(-0.2F, 0F, 0F, 1, 1, 4);
      head4.setRotationPoint(-5F, 19.8F, 10.8F);
      head4.setTextureSize(64, 32);
      head4.mirror = true;
      setRotation(head4, 0F, 0F, -0.2010743F);
      head5 = new ModelRenderer(this, 0, 0);
      head5.addBox(0F, 0F, 0F, 1, 1, 4);
      head5.setRotationPoint(2F, 19F, 9F);
      head5.setTextureSize(64, 32);
      head5.mirror = true;
      setRotation(head5, -0.2876179F, 0.8552113F, 0F);
      head6 = new ModelRenderer(this, 0, 0);
      head6.addBox(0F, 0F, 0F, 1, 1, 4);
      head6.setRotationPoint(4.5F, 20F, 10.8F);
      head6.setTextureSize(64, 32);
      head6.mirror = true;
      setRotation(head6, 0F, 0F, 0.2010794F);
      legsquare2 = new ModelRenderer(this, 0, 0);
      legsquare2.addBox(0F, 0F, 0F, 1, 3, 3);
      legsquare2.setRotationPoint(3F, 12F, -6F);
      legsquare2.setTextureSize(64, 32);
      legsquare2.mirror = true;
      setRotation(legsquare2, 0F, 0F, 0F);
      legsqaure1 = new ModelRenderer(this, 0, 0);
      legsqaure1.addBox(0F, 0F, 0F, 1, 3, 3);
      legsqaure1.setRotationPoint(-4F, 12F, -6F);
      legsqaure1.setTextureSize(64, 32);
      legsqaure1.mirror = true;
      setRotation(legsqaure1, 0F, 0F, 0F);
      legup1 = new ModelRenderer(this, 0, 0);
      legup1.addBox(0F, 0F, 0F, 1, 2, 7);
      legup1.setRotationPoint(-3F, 17F, 3F);
      legup1.setTextureSize(64, 32);
      legup1.mirror = true;
      setRotation(legup1, 2.119181F, 0F, 0F);
      claw1 = new ModelRenderer(this, 0, 0);
      claw1.addBox(0F, 0F, 0F, 1, 1, 4);
      claw1.setRotationPoint(-3F, 13F, 1F);
      claw1.setTextureSize(64, 32);
      claw1.mirror = true;
      setRotation(claw1, -0.6093161F, -1.170197F, 0F);
      claw2 = new ModelRenderer(this, 0, 0);
      claw2.addBox(0F, -1F, 0F, 1, 1, 6);
      claw2.setRotationPoint(-6F, 16F, 2F);
      claw2.setTextureSize(64, 32);
      claw2.mirror = true;
      setRotation(claw2, -0.5948578F, -0.1396263F, -0.1115358F);
      claw3 = new ModelRenderer(this, 0, 0);
      claw3.addBox(0F, 0F, 3F, 1, 1, 3);
      claw3.setRotationPoint(-6F, 16F, 2F);
      claw3.setTextureSize(64, 32);
      claw3.mirror = true;
      setRotation(claw3, -0.5948578F, -0.1396263F, -0.1115358F);
      claw4 = new ModelRenderer(this, 0, 0);
      claw4.addBox(-0.2F, -1F, 0F, 1, 1, 3);
      claw4.setRotationPoint(-6F, 19F, 6F);
      claw4.setTextureSize(64, 32);
      claw4.mirror = true;
      setRotation(claw4, -2.156359F, -0.1487144F, -0.1115358F);
      claw5 = new ModelRenderer(this, 0, 0);
      claw5.addBox(0F, 0F, 0F, 1, 1, 5);
      claw5.setRotationPoint(2F, 13F, 1F);
      claw5.setTextureSize(64, 32);
      claw5.mirror = true;
      setRotation(claw5, -0.5349547F, 0.9842978F, 0F);
      claw6 = new ModelRenderer(this, 0, 0);
      claw6.addBox(0F, -1F, 0F, 1, 1, 6);
      claw6.setRotationPoint(5F, 16F, 2F);
      claw6.setTextureSize(64, 32);
      claw6.mirror = true;
      setRotation(claw6, -0.5948606F, 0.1396263F, 0.111544F);
      claw7 = new ModelRenderer(this, 0, 0);
      claw7.addBox(0F, 0F, 3F, 1, 1, 3);
      claw7.setRotationPoint(5F, 16F, 2F);
      claw7.setTextureSize(64, 32);
      claw7.mirror = true;
      setRotation(claw7, -0.5948578F, 0.1396263F, 0.111544F);
      claw8 = new ModelRenderer(this, 0, 0);
      claw8.addBox(0.2F, -1F, 0F, 1, 1, 3);
      claw8.setRotationPoint(5F, 19F, 6F);
      claw8.setTextureSize(64, 32);
      claw8.mirror = true;
      setRotation(claw8, -2.156359F, 0.1487195F, 0.111544F);
      legup2 = new ModelRenderer(this, 0, 0);
      legup2.addBox(0F, 0F, 0F, 1, 2, 7);
      legup2.setRotationPoint(2F, 17F, 3F);
      legup2.setTextureSize(64, 32);
      legup2.mirror = true;
      setRotation(legup2, 2.119181F, 0F, 0F);
      claw9 = new ModelRenderer(this, 0, 0);
      claw9.addBox(0F, 0F, 0F, 1, 7, 1);
      claw9.setRotationPoint(1F, 16F, 3F);
      claw9.setTextureSize(64, 32);
      claw9.mirror = true;
      setRotation(claw9, 2.974289F, 0F, 0F);
      claw15 = new ModelRenderer(this, 0, 0);
      claw15.addBox(0F, 0F, 0F, 1, 7, 1);
      claw15.setRotationPoint(-2F, 16F, 3F);
      claw15.setTextureSize(64, 32);
      claw15.mirror = true;
      setRotation(claw15, 2.974289F, 0F, 0F);
      body5 = new ModelRenderer(this, 0, 0);
      body5.addBox(0F, 0F, 0F, 6, 2, 7);
      body5.setRotationPoint(-3F, 16F, 0F);
      body5.setTextureSize(64, 32);
      body5.mirror = true;
      setRotation(body5, -0.3915114F, 0F, 0F);
      claw11 = new ModelRenderer(this, 0, 0);
      claw11.addBox(0F, 0F, 0F, 1, 12, 1);
      claw11.setRotationPoint(1F, 10F, 3.3F);
      claw11.setTextureSize(64, 32);
      claw11.mirror = true;
      setRotation(claw11, 1.469183F, 0.1047198F, 0F);
      claw16 = new ModelRenderer(this, 0, 0);
      claw16.addBox(0F, 0F, 0F, 1, 12, 1);
      claw16.setRotationPoint(-2F, 10F, 3.4F);
      claw16.setTextureSize(64, 32);
      claw16.mirror = true;
      setRotation(claw16, 1.543532F, -0.1047198F, 0F);
      claw10 = new ModelRenderer(this, 0, 0);
      claw10.addBox(0F, 0F, 0F, 1, 12, 1);
      claw10.setRotationPoint(1F, 10F, 3.4F);
      claw10.setTextureSize(64, 32);
      claw10.mirror = true;
      setRotation(claw10, 1.543534F, 0.1047198F, 0F);
      claw17 = new ModelRenderer(this, 0, 0);
      claw17.addBox(0F, 0F, 0F, 1, 12, 1);
      claw17.setRotationPoint(-2F, 10F, 3.3F);
      claw17.setTextureSize(64, 32);
      claw17.mirror = true;
      setRotation(claw17, 1.469175F, -0.1047198F, 0F);
      claw18 = new ModelRenderer(this, 0, 0);
      claw18.addBox(0F, 0F, 0F, 1, 5, 1);
      claw18.setRotationPoint(-3.2F, 10.2F, 14.2F);
      claw18.setTextureSize(64, 32);
      claw18.mirror = true;
      setRotation(claw18, -0.1115358F, -0.1047198F, 0F);
      claw14 = new ModelRenderer(this, 0, 0);
      claw14.addBox(0F, 0F, 0F, 1, 5, 1);
      claw14.setRotationPoint(2.2F, 10.2F, 14.2F);
      claw14.setTextureSize(64, 32);
      claw14.mirror = true;
      setRotation(claw14, -0.111544F, 0.1047198F, 0F);
      claw19 = new ModelRenderer(this, 0, 0);
      claw19.addBox(0F, 0F, 0F, 1, 3, 1);
      claw19.setRotationPoint(-2.8F, 10.2F, 11.2F);
      claw19.setTextureSize(64, 32);
      claw19.mirror = true;
      setRotation(claw19, -0.1115358F, -0.1047198F, 0F);
      claw13 = new ModelRenderer(this, 0, 0);
      claw13.addBox(0F, 0F, 0F, 1, 3, 1);
      claw13.setRotationPoint(1.8F, 10.2F, 11.2F);
      claw13.setTextureSize(64, 32);
      claw13.mirror = true;
      setRotation(claw13, -0.1115358F, 0.1047198F, 0F);
      claw20 = new ModelRenderer(this, 0, 0);
      claw20.addBox(0F, 0F, 0F, 1, 1, 1);
      claw20.setRotationPoint(-2.5F, 10.2F, 8.2F);
      claw20.setTextureSize(64, 32);
      claw20.mirror = true;
      setRotation(claw20, -0.1115358F, -0.1047198F, 0F);
      claw12 = new ModelRenderer(this, 0, 0);
      claw12.addBox(0F, 0F, 0F, 1, 1, 1);
      claw12.setRotationPoint(1.5F, 10.2F, 8.2F);
      claw12.setTextureSize(64, 32);
      claw12.mirror = true;
      setRotation(claw12, -0.1115358F, 0.1047198F, 0F);
      Hind_up_1 = new ModelRenderer(this, 0, 0);
      Hind_up_1.addBox(0F, 1F, 0F, 3, 5, 3);
      Hind_up_1.setRotationPoint(4F, 12F, -6F);
      Hind_up_1.setTextureSize(64, 32);
      Hind_up_1.mirror = true;
      setRotation(Hind_up_1, -0.0872665F, 0F, 0F);
      Hind_across_1 = new ModelRenderer(this, 0, 0);
      Hind_across_1.addBox(0F, 0F, 0F, 2, 6, 2);
      Hind_across_1.setRotationPoint(4F, 18F, -10.7F);
      Hind_across_1.setTextureSize(64, 32);
      Hind_across_1.mirror = true;
      setRotation(Hind_across_1, 1.570796F, 0F, 0F);
      Hind_foot_1 = new ModelRenderer(this, 0, 0);
      Hind_foot_1.addBox(0F, 0F, -2F, 2, 4, 2);
      Hind_foot_1.setRotationPoint(4F, 24F, -8F);
      Hind_foot_1.setTextureSize(64, 32);
      Hind_foot_1.mirror = true;
      setRotation(Hind_foot_1, -1.570796F, 0F, 0F);
      Hind_leg_1 = new ModelRenderer(this, 0, 0);
      Hind_leg_1.addBox(0F, 0F, -1F, 2, 5, 2);
      Hind_leg_1.setRotationPoint(4F, 22.3F, -11F);
      Hind_leg_1.setTextureSize(64, 32);
      Hind_leg_1.mirror = true;
      setRotation(Hind_leg_1, 2.879793F, 0F, 0F);
      Hind_up_2 = new ModelRenderer(this, 0, 0);
      Hind_up_2.addBox(0F, 1F, 0F, 3, 5, 3);
      Hind_up_2.setRotationPoint(-7F, 12F, -6F);
      Hind_up_2.setTextureSize(64, 32);
      Hind_up_2.mirror = true;
      setRotation(Hind_up_2, -0.0872665F, 0F, 0F);
      Hind_across_2 = new ModelRenderer(this, 0, 0);
      Hind_across_2.addBox(0F, 0F, 0F, 2, 6, 2);
      Hind_across_2.setRotationPoint(-6F, 18F, -10.7F);
      Hind_across_2.setTextureSize(64, 32);
      Hind_across_2.mirror = true;
      setRotation(Hind_across_2, 1.570796F, 0F, 0F);
      Hind_foot_2 = new ModelRenderer(this, 0, 0);
      Hind_foot_2.addBox(-6F, 0F, 2F, 2, 4, 2);
      Hind_foot_2.setRotationPoint(0F, 20F, -8F);
      Hind_foot_2.setTextureSize(64, 32);
      Hind_foot_2.mirror = true;
      setRotation(Hind_foot_2, -1.570796F, 0F, 0F);
      Hind_leg_2 = new ModelRenderer(this, 0, 0);
      Hind_leg_2.addBox(0F, 0F, -1F, 2, 5, 2);
      Hind_leg_2.setRotationPoint(-6F, 22.3F, -11F);
      Hind_leg_2.setTextureSize(64, 32);
      Hind_leg_2.mirror = true;
      setRotation(Hind_leg_2, 2.879793F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    tail2.render(f5);
    tail1.render(f5);
    body_1.render(f5);
    tail6.render(f5);
    tail3.render(f5);
    tail4.render(f5);
    tail5.render(f5);
    body2.render(f5);
    body3.render(f5);
    body4.render(f5);
    body6.render(f5);
    body7.render(f5);
    head.render(f5);
    head2.render(f5);
    head1.render(f5);
    head3.render(f5);
    head4.render(f5);
    head5.render(f5);
    head6.render(f5);
    legsquare2.render(f5);
    legsqaure1.render(f5);
    legup1.render(f5);
    claw1.render(f5);
    claw2.render(f5);
    claw3.render(f5);
    claw4.render(f5);
    claw5.render(f5);
    claw6.render(f5);
    claw7.render(f5);
    claw8.render(f5);
    legup2.render(f5);
    claw9.render(f5);
    claw15.render(f5);
    body5.render(f5);
    claw11.render(f5);
    claw16.render(f5);
    claw10.render(f5);
    claw17.render(f5);
    claw18.render(f5);
    claw14.render(f5);
    claw19.render(f5);
    claw13.render(f5);
    claw20.render(f5);
    claw12.render(f5);
    Hind_up_1.render(f5);
    Hind_across_1.render(f5);
    Hind_foot_1.render(f5);
    Hind_leg_1.render(f5);
    Hind_up_2.render(f5);
    Hind_across_2.render(f5);
    Hind_foot_2.render(f5);
    Hind_leg_2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
}