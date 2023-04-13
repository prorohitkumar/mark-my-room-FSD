import React,{useState,useEffect} from 'react'
import{ FaArrowAltCircleRight, FaArrowAltCircleLeft,FaShare,FaLandmark} from 'react-icons/fa'
import {BiPhoneCall ,BiRupee,BiBuildingHouse,BiCctv,BiBusSchool} from 'react-icons/bi'
import {IoIosPeople} from 'react-icons/io'
import {GoLocation} from 'react-icons/go'
import {BsChatDots} from 'react-icons/bs'
import {IoSchoolOutline,IoTrainOutline,IoTvSharp} from 'react-icons/io5'
import {FaUniversity,FaFan,FaRegLightbulb,FaChair} from 'react-icons/fa'
import {MdLocalHospital,MdOutlinePark,MdCable,MdOutlineChair} from 'react-icons/md'
import {AiOutlineShoppingCart,AiOutlineWifi} from 'react-icons/ai'
import {RiFridgeLine} from 'react-icons/ri'
import {ImPower} from 'react-icons/im'
import {GiByzantinTemple,GiBed,GiTheaterCurtains,GiSofa,GiWaterFlask} from 'react-icons/gi'
import images from './images';
import "./PropertyDetails.css";
export const PropertyDetails = () => {

 
  const imagesData  = images;
  const[current,SetCurrent] = useState(0);
  const length  = images.length;
  console.log(length);



  const nextSlide =() =>{
    SetCurrent(current=== length -1?0 :current+1) 
  } ;

  const prevSlide =() =>{
    SetCurrent(current=== 0? length-1:current-1) 
  } ;
  console.log(current)

  if(!Array.isArray(images) || length<=0)
  {
    return null;
  }
  
  return (
    <>
     <div className='title'>
<div class="propertyTitle">3 BHK Flat for rent in Noida </div>
<div className='share'>
  <b><FaShare/></b>
</div>
     </div>
    <div className='slider'>
        {images.map((slide,index) =>{
            return(
              <div className={index===current ?'slide active' :'slide'} key ={index}>
                {index===current &&(
                  <img src={slide.Image} alt="unable to load" className='image'/>
                )} 
                </div>
            )
        })}
         <div>
      <FaArrowAltCircleLeft className='left-arrow' onClick={prevSlide}  />
      <FaArrowAltCircleRight className='right-arrow' onClick={nextSlide} />
      </div>
    </div>
    < div className='left'>      
    <div className="left-blocks">
      <h3 className='postedby'>Posted By</h3>
<img src="https://freesvg.org/img/winkboy.png" alt="pic" className='avtar' />
<h3 className='postedby'>James Rayan</h3>
<h3 className='postedby'>Broker</h3>
<h3 className='postedby'><BiPhoneCall/>+91-11111111111</h3>
    </div>

      <div className="property-discription">
       <div className='places-nearby-list-item-icons'><b>Property discription</b></div>
       <div className='property-discription-text'><p>this is a very very good best property nearly london dvbsdjn sdhfvshfcsbc sdjc ds jcsd</p></div>
        </div>
        <div className="left-blocks">
       <div className='places-nearby-list-item-icons'><b>Places Nearby</b></div> 
       <div className="places-nearby-list">
       <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><b><IoSchoolOutline/> school</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
        <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><b><FaUniversity/> university</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
       </div>
       <div className="places-nearby-list">
       <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><b><MdLocalHospital/>hospital</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
        <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><b><IoTrainOutline/> metro</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
       </div>
       <div className="places-nearby-list">
       <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><b><AiOutlineShoppingCart/> market</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
        <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><b><BiBusSchool/> bus station</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
       </div>
       <div className="places-nearby-list">
       <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><MdOutlinePark/><b> Park</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
        <div className='places-nearby-list-item'>
        <div className='places-nearby-list-item-icons'><GiByzantinTemple/><b> Temple</b></div>
        <div className='checkbox'>{'\u2714'}</div>
        </div>
       </div>
        </div>
        </div>

      <div className="buttons">
        <button className='booknow'><b>Book Now</b></button>
        <button className='chat'><b> <BsChatDots style={{marginTop:"2px",fontSize:"35px"}}/></b></button>
      </div>
      <div className='right'>
      <div className='property-details'>
        <div className='item'>
          <div className='item-element'><b>Property Owner</b></div>
          <div className='item-element'><b>owner name</b></div>
        </div>
        <div className='item'>
        <div className='item-element'><b><BiBuildingHouse/> Property Type</b></div>
          <div className='item-element'><b>3 BHK</b></div>
        </div>
        </div>
        <div className='property-details'>
        <div className='item'>
          <div className='item-element'><b><FaLandmark className='icon'/> Landmark</b></div>
          <div className='item-element'><b>near new Delhi metro station</b></div>
        </div>
        <div className='item'>
        <div className='item-element'><b><IoIosPeople className='icon'/>Preferred Tenant</b></div>
          <div className='item-element'><b>Family / Bachelor</b></div>
        </div>
        </div>
        <div className='property-details'>
        <div className='item'>
        <div className='item-element'><b><MdOutlineChair className='icon'/>Furnishing</b></div>
          <div className='item-element'><b>Semi-Furnished</b></div>
        </div>
      
        <div className='item'>
        <div className='item-element'><b>Posted Date</b></div>
          <div className='item-element'><b>7 July 2022</b></div>
        </div>
        </div>
        <div className='property-details'>
        <div className='item'>
        <div className='item-element'><b>Rent PM</b></div>
          <div className='item-element'><b>&#8377;5000</b></div>
        </div>
        <div className='item'>
        <div className='item-element'><b>Advance deposit</b></div>
          <div className='item-element'><b>&#8377;5000</b></div>
        </div>
        </div>
        <div className='property-details'>
        <div className='location'>
          <div className='item-element'><GoLocation/></div>
          <div className='item-element'><b>House no 7, Grand London , America, Asia 00000</b></div></div>
        </div>
      <div className='amenities'>
<div className='text2' ><b>Aminites</b></div>
<div className='amenities-list'>
<div className='amenities-list-item'>
  <div className="icon"><GiBed /></div>
  <div className="amenities-list-item-element"><b> Bed </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><BiCctv /></div>
  <div className="amenities-list-item-element"><b> CCTV </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><FaFan /></div>
  <div className="amenities-list-item-element"><b> Fan </b> </div>
  <div className='crossbox'>{'\u2718'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><FaRegLightbulb /></div>
  <div className="amenities-list-item-element"><b> Lights </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><IoTvSharp /></div>
  <div className="amenities-list-item-element"><b> TV </b> </div>
  <div className='crossbox'>{'\u2718'}</div>
  </div>
</div>
<div className='amenities-list'>
<div className='amenities-list-item'>
  <div className="icon"></div>
  <div className="amenities-list-item-element"><b> Geyser </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><GiTheaterCurtains/></div>
  <div className="amenities-list-item-element"><b> Curtains </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><GiSofa/></div>
  <div className="amenities-list-item-element"><b> sofa </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><GiWaterFlask /></div>
  <div className="amenities-list-item-element"><b> RO </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><AiOutlineWifi/></div>
  <div className="amenities-list-item-element"><b> Wi-Fi</b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
</div>
<div className='amenities-list'>
<div className='amenities-list-item'>
  <div className="icon"><RiFridgeLine/></div>
  <div className="amenities-list-item-element"><b> Refridgeratore </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><BiCctv /></div>
  <div className="amenities-list-item-element"><b> CCTV </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><MdCable/></div>
  <div className="amenities-list-item-element"><b> Cable </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><ImPower/></div>
  <div className="amenities-list-item-element"><b>Power backup</b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
  <div className='amenities-list-item'>
  <div className="icon"><FaChair /></div>
  <div className="amenities-list-item-element"><b> Chair </b> </div>
  <div className='checkbox'>{'\u2714'}</div>
  </div>
</div>

        </div>
        </div>
      </>
  )
}
